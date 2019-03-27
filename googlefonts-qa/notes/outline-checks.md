# Checking outlines after extrapolation

It was necessary to extrapolate a `Light` master to allow Fira Code to build via FontMake. As a result, some outline errors may have made their way into the glyphs in this new Master, because extrapolation is a useful but imperfect tool.

For the most part, I will abstain from fixing every little outline issue, because by and large, things here are well-drawn, and haven't been extrapolated in too extreme a manner. However, I will use the Glyphs App extension Red Arrows to find potential problems, then check them over and fix what seems to be clearly wrong.

### /U-cy

The main stem of this glyph has a "kink" that seems unintentional.

![](assets/2019-03-27-13-35-37.png)


### Zhedescender-cy

This has a component that isn't needed, and this juts out in the Bold master, causing an outline blip.

![](assets/2019-03-27-13-41-12.png)

![](assets/2019-03-27-13-40-23.png)

![](assets/2019-03-27-13-39-56.png)

If we look at Fira Sans, it's clear what this shape is supposed to do:

![](assets/2019-03-27-13-46-21.png)

The component was transformed to (10%, 10%) – way too small. I've adjust that to (85%, 100%) in the Bold and (100%,100%) in the light. Now it's like this:

![](assets/2019-03-27-13-50-55.png)
![](assets/2019-03-27-13-51-17.png)


## Kastroke-cy

This crossbar is overly-thick, compared to others – I'll thin it out a bit:

![](assets/2019-03-27-13-48-03.png)

## (Small) issues I'm leaving

Often, crossbars have unnecessary points. These aren't really needed for the shapes and add a very small amount of data, but they're harmless, so I won't remove them right now.

![](assets/2019-03-27-13-38-30.png)