# CSS Flexbox (TLDR from Odin Project)

- The better and current bare minimum standard for how organise content should be done.
- Better than the box model, and the start of adding dynamic elements.
- Integrated with CSS style sheets.
- Frankly to experiment with designs, just use Figma and export the corresponding css.

```html

<style>
.flex-container {
  display: flex;
}

/* this selector selects all divs inside of .flex-container */
.flex-container div {
  background: peachpuff;
  border: 4px solid brown;
  height: 100px;
  flex: 1;
}
</style>

<div class="flex-container">
  <div class="one"></div>
  <div class="two"></div>
  <div class="three"></div>
</div>
```

This code takes the 3 divs in the html script, and arranges them horizontally to take up the entire horizontal section at a specified height. Adding more stuff into a flex container will dynamically resize it to accomodate it.

- set `display: flex;` for the container
- set `flex:1;` for container items.
- flex containers can be nested, so you can have a container as an item.
    - use multiple of these to make complex layouts.

<img src="https://cdn.statically.io/gh/TheOdinProject/curriculum/495704c6eb6bf33bc927534f231533a82b27b2ac/html_css/v2/foundations/flexbox/imgs/05.png" height=auto>

## Some syntax tips

### Axes (Main and Cross)

- When a container is created, you have 2 axes to work with.
    - `Main Axis` &#8212; X Axis
    - `Cross Axis` &#8212; Y Axis
    - setting `flex-direction: column;` in your container swaps these axes. default value is `row`.

### Aligning content with `justify-content`

- `justify-content` can take values `flex-start`  `flex-end` to stick to the start or end of the main axis.
    - `center` keeps everything to the middle of the main axis
    - `space-between` distributes all items across the main axis
    - `space-around` is just `space-between` with extra padding at the start and end of the main axis
    -`space-evenly` is just `space-around` but all spaces involved are now the same length.

- `align-items` does the same thing as `justify content` except for the cross axis. Above 3 values apply.
    - `baseline` aligns flex items using text position as a reference.
- `align-self` applies alignment only to a single item.

> [!note]
>
> - `justify-content` and `align-items` are added to the flex container, not the flex item.
> - `align-self` is added to the flex items to override the above two flex container rules.

Both the above features are easier to visualise with figma, so I recommend trying it there.

### Spacing content with `Gap`

- specifies the space between flex items.

### Dealing with content overflow with `flex-wrap`

- `flex-wrap` specifies how your content should react when you have more content than horizontal space (depending on browser width).
    - `nowrap` means you force all items to be in 1 box
    - `wrap` means items will flow to the next line on the main axis.
        - A new property can be edited if `flex-wrap: wrap;`

### Ordering items

- `order` attribute can be used to reorder items in your html and override the order that items are displayed in your browser.
- Honestly not recommended since it makes your scripts and confusing.

## Growing and Shrinking

### Shorthand `flex` syntax

- Shorthand properties &#8212; properties that let you set a bundle of related properties in 1 line declaration. You can gloss over this for details on how `flex` is implemented since these specifications are rarely ever needed.

- `flex:1;` defaults to:

    - `flex-grow: 1` &#8212; referring to the "growth factor" of an element
        - basically a ratio for the proportionate size of a certain element.
        - if only 1 element has `flex-grow: 2` and the rest have 1, it will always be twice as big as the rest.

    - `flex-shrink: 1` &#8212; referring to the "shrink factor" of an element
        - if the total size of the items in the container is larger than the container, this decides whether your elements shrink.
            - setting this to `0` makes it not shrink
            - setting to `1` means even shrinking over all elements.

    - `flex-basis: 0` &#8212; the intial size of the item, respecting the main axis.
        - Basically:
          1. Determine the main axis
          2. check the value or name and find the corresponding value for that axis. If main axis is horizontal (which is what it is by default) that makes it the width or related values' if its vertical, its the height.
          3. That value will be the reference size. (ie flex basis refers )
        - Not the same as using `width`, because that forces the content size. `flex-shrink` and `flex-grow` just adapt to this content size.
        - using `flex-basis: auto` (which is technically the default value) makes flexbox refer to the width of the element's content.

  and the more formal way of declaring this is `flex: 1 1 0`. In any case, this abstracts your layouts from your content. Also, it is implied that all direct child elements of a flex container are flex items, so there are different default attributes applied (ie `flex-basis` being `auto`).

    - random note, `flex: auto` is shorthand for `flex: 1 1 auto`.

> [!warning] Specifying width with flexbox
>
> Its possible to set a width for your elements, but flexbox may not respect these values. It will still dynamically fit your browser window.

---

## Exercise pointers

- sometimes you just need to realise that the content size > the container size, and it doesn't overflow by default. the elements don't expand dynamically. It just sucks.
- sometimes its easier to design flexbox layouts from inside out: start with the elements that definitely need to be flex items and work outwards.
    - `gap` is useful when you don't have a lot of space, otherwise use `minmax`.

## Sources

- [Interneting is hard | Flexbox](https://internetingishard.netlify.app/html-and-css/flexbox/index.html)
- [Slaying The Dragon | Flexbox in 8 minutes](https://youtu.be/phWxA89Dy94?si=JTTjIDYCaKSBd2Nk)
- [Kevin Powell | How Flex basis actually works](https://youtu.be/jx4FtPlDXJg?si=xpdwYREni9H8UAGL)
- [MDN | Flexbox Docs](https://developer.mozilla.org/en-US/docs/Web/CSS/flex)
- W3Schools

### Cheatsheets

- <https://flexbox.malven.co/>
