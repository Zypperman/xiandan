# Layouts with CSS

## The Box Model

- Every rendered HTML elements exists in a box, with:
    - a margin
        - refers to space between 2 element borders
    - padding
        - refers to space between an element's content and its borders
    - borders
        - refers to space between margin and padding.
        - think of it (by default) as a thick black line
    - height and width specify the size of the content of the element.
        - you can also indicate under the box-sizing attribute whether you want your content to factor in their margins and border padding when you size your element. (ie the content will shrink down such that with the margin, border and padding, you end up with an element that has the same specified height and width).
            - defaults to `content-box`, devs wil usually change it to `border-box`
            - `content-box` &#8212; height and width apply to content
            - `content-box` &#8212; height and width factor in box model dimensions

Best way to visualise this is with the DOM, where you can see this visualisation:
![typical box model you'll see when you inspect elements with the DOM](https://www.simplilearn.com/ice9/free_resources_article_thumb/CSS-Box-Model.png)

- Coloring the outlines can help with visualising these boxes. (ie. with `* {outline: 2px solid red;}`)

## Block and Inline boxes

CSS's 2 Box types, each has different element behaviour and interactions. Controlled by the `display` property.

- Block elements just exist and consecutively appear below each other

- Inline elements exist within block elements (ie `<a>`)
    - margin and padding are typically not added to these elements

- Inline block elements exist as well, but people typically opt for flexbox layouts to accomplish the same thing, but better.

### CSS syntactic sugar

- You can specify specific sides of the margin to be altered with `margin-top/right/bottom/left`.
- both margin and padding can also have shorthand declaration for side-specific values with the format `margin <top_len> <right_len> <bot_len> <left_len>` (it goes clockwise)
    - with 3 values, it becomes `<top> <sides> <bottom>`
    - with 2 values, it becomes `<top bottom> <left right>`

### `Div` and `Span` elements

Just empty containers that act as hooks for styles  

- ie we just give them classes and IDs instead of the elements themselves to organise our script, or we want to group some elements to have the same style.
- `Div` is for block boxes, `Span` is for inline boxes.


> [!warning] <code>margin:auto;</code> : what does it do?
> - horizontally centers the element in its box.
> - used with specific sides ie margin-left, you just align to that side.

---

## Centering Content

## Sources

- [ByteGrad's "Box-sizing property"](https://www.youtube.com/watch?v=HdZHcFWcAd8&ab_channel=ByteGrad) | [MDN Docs](https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Styling_basics/Box_model) | [CSS Tricks' margin keywords](https://css-tricks.com/almanac/properties/m/margin/)
- [MDN Normal Flow](https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/CSS_layout/Introduction)