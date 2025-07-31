# CSS Basics and concepts

## Fundamentals

- Each style sheet's script follows the template of:

    ```css
    <selector>{
        property1:value1;
        property2:value2;
        }
    ```

    - selectors are for picking what elements this style applies to
    - properties and values refer to diff style aspects like color or size.
- Styles are applied from top to bottom in a css script, like stacking layers.

### Adding css to HTML

- inline css &#8212; insert style-attribute one-liners into the style attribute of a specific element (ie. `<div style='color:white;'>`)
    - unconventional since this is difficult to maintain
- internal css &#8212; embed it in a `<style>` tag:

    ```html
    <head>
    <style>
        div {
        color: white;
        background-color: black;
        }

        p {
        color: red;
        }
    </style>
    </head>
    <body>
    ...
    </body>
    ```

    - suitable for just adding elements to a single site ad-hoc

- External CSS: &#8212; include it from a separate file
    - add the hyperlink to the css file's relative filepath in your `<head>` content with a `<link>` tag:

        ```html
        <!-- index.html -->
        <head>
        <link rel="stylesheet" href="styles.css">
        </head>
        ```

    - by convention, name this file `style.css` or `styles.css`.
    - Ideal for webdev CI/CD.

### selector types

- `*` to pick everything (known as the universal selector)
- `<type name>` to pick elements with that type (ie `div {color:white;}`)
- `.<class name>` to pick elements by class
    - for elements like `<div class = thing>`, select it with `.thing{color:white;}`
        - class names are case sensitive and can't start with numbers
        - class names should also use hyphens instead of spaces,
        - a tag can belong to multiple classes and are space-separated (ie. `<div class="alert-text severe-alert">`)
- `#<id name>` to pick elements by ID ie. `<div id="title">My Awesome 90's Page</div>`

> [!tip] When to use the div tag
>
> - div is basically an empty container for adding style to.
> - Ideally, apply styles directly to tags like `h#` and `p` and use classes and IDs for more granular control.
> - Divs are just there to simplify your stack.

## CSS's syntactic sugar

### Selecting groups

If two classes have common style-attributes, you can just comma-separate their names in your style script, then add more class-specific blocks afterwards:

```css
/* modified from Odin project: */
.read,
.unread {
color: white;
background-color: black;
}

.read {
/* several unique declarations */
}

.unread {
/* several unique declarations */
}
```

### Chaining Selections

If you want styles that should apply to elements with multiple classes(ie some element specifically with both the `subsection` and `header` class) you can chain them with periods:

```css
/* modified from Odin project: */
/* for elements like <div class = "subsection header"> */

.subsection.header { 
color: red;
}

/* for chaining class and ID together */
.subsection#preview {
  color: blue;
}
```

Just note that this doesn't really work with distinct html element types (ie. you can't chain `h1` and `div`).

### Combinators

For selecting subgroups of elements (including html element types) to style.

- Descendant combinator (space)
    - exactly the same as selecting groups, just that you now deal with concepts like parent and child classes
    - ie selecting all p elements in a div, you do `div p {style content;}`
- Child combinator (>)
    - for selecting strictly child elements of another element
    - different from the descendant combinator because it excludes tags with both
    - different from chaining
- Next sibling combinator (+)
    - selects an element that is directly after another specific element
- Subsequent-sibling combinator (~)
    - selects all elements that are next siblings of a specified element

> [!warning] Chain vs Descendant Cbtr vs Child Cbtr
>
> - Chain &#8212; all mentioned classes are in the same attribute / the attribute of included elements have both classes, not by inheritance
> - Descendant &#8212; subsequent selectors are picked up by inheritance (ie p ul means all `ul` elements anywhere inside a `p` element are picked up)
>     - aka that child will only be selected if it is nested inside ancestor, regardless of how deep that nesting is.
> - Child &#8212; ONLY the direct next level of subsequent selectors are picked up by inheritance (ie p ul means only direct child `ul` elements anywhere inside a `p` element are picked up, any deeper uls are ignored)

## Common style properties

- `color`, `background-color` and color-related attributes &#8212; takes pre-selected color names recognised by css natively
    - can also take on HEX, RGB, and HSL values, see [w3cs](https://www.w3schools.com/cssref/css_colors_legal.php) for color value formats and [recognised color names](https://www.w3schools.com/cssref/css_colors.php)
- fonts &#8212; use quotes for specific font family names, no quotes for generic font families, browsers will use the first ones that they can render.
    - font-size &#8212; in `px`
    - font-weight &#8212; for visual effects like bold or italics, also takes on numbers
    - text-align
- `height` and `width` for images &#8212; in `px`, but talso takes on `auto` for proportional size changes.
    - Alternative rules include (from w3schools):
    - auto - the browser calculates the margin
    - length - specifies a margin in px, pt, cm, etc.
    - % - specifies a margin in % of the width of the containing element
    - inherit - specifies that the margin should be inherited from the - parent element

---

## Order of applying styles (the C (cascade) of CSS)

- If some graphics don't render right, its because:
    - your browser cant interpret what you outlined in css and went to its default behaviour and presentation of elements.
    - some property you used works in an unexpected way.
    - the order of applying styles was unexpected.
- An easier way to interpret CSS rules is that each block is a layer, and you're just layering styles over each other in your site.

### Cascading rules

If two styles scripts apply to 1 element at the same level, follow these rules:

1. More specific delarations > less specific declarations
    - Specificity = number of n level selectors
    - in-line styles are the most specific (ie `<p style='color:white;'>`)
    - ID > Class > element type selectors.
    - if 2 style scripts use the same level of selectors, look at how many they use, using more takes precedence
        - ie. 1 ID selector < 1 ID + 1 class selector.

    - Note that precedence only needs to apply if there are conflicting declarations.
    - Combinators also do not contribute to complexity (ie. `*`, `+`, `space` etc)

    ```html
    <!-- example adapted from Odin project -->
    <!-- index.html -->

    <div class="main">
    <div class="list subsection">Red text</div>
    </div>

    ```

    ```css
    /* rule 1 */
    .subsection {
    color: blue;
    }

    /* rule 2 */
    .main .list {
    color: red; /*applies because more selectors are being used*/
    }
    ```

2. Inheritance rules: if Child elements are selected, they don't adopt the parent element's style rules.
    - ie (taken from odin project):

        ```html
        <!-- index.html -->
        <head>
        <style>
        #parent {
        color: red;
        }

        .child {
        color: blue;
        }
        </style>    
        </head>
        <div id="parent"> <!-- becomes red -->
        <div class="child"></div> <!-- becomes blue since its red was inherited from being under the element with id=parent -->
        </div>
        ```

3. If above 2 criteria are contested, just look at which is further down on the style sheet. styles are applied one selector over another down the sheet.

### Other rule precedences

- putting `!important` after a specific rule brings that style to the top layer.


## Sources

- [W3schools | CSS](https://www.w3schools.com/css/) (for reference)
- Odin project
  
### CSS rules

- [wattenberger CSS reference](https://2019.wattenberger.com/blog/css-cascade) | [Kevin Powell, Specificity in depth](https://youtu.be/c0kfcP_nD9E?si=sWQdlKAhKNoVYpEP) | [Keegan's Specificity Calculator](https://specificity.keegan.st/) | [MDN CSS reference](https://developer.mozilla.org/en-US/docs/Web/CSS/Reference#index)
