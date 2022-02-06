# Checking outlines after extrapolation

It was necessary to extrapolate a `Light` master to allow Fira Code to build via FontMake. As a result, some outline errors may have made their way into the glyphs in this new Master, because extrapolation is a useful but imperfect tool.

For the most part, I will abstain from fixing every little outline issue, because by and large, things here are well-drawn, and haven't been extrapolated in too extreme a manner.

## General Process

I will use the Glyphs App extension Red Arrows to find potential problems, then check them over and fix what seems to be clearly wrong.

If it is not super obvious how to fix a potential issue, I will generally: 
- Check what the Bold master does
- Check what Fira Mono (the ancestor of Fira Code) does in its Regular master
- Copy the existing layer to the background, and make that copied layer visible to provide a basic guide for my changes. For example:

![](assets/2019-03-28-13-53-22.png)

I am not trying to change the design, but rather, to fix unintended vector issues that make the design less useful.

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


## Kahook-cy

Before:

![](assets/2019-03-27-13-52-23.png)

Now: 

![](assets/2019-03-27-13-53-17.png)


## Lha-cy

Mismatch in upper-left:
![](assets/2019-03-28-13-40-08.png)

I removed the overlap in that stroke:

![](assets/2019-03-28-13-42-04.png)

## be-cy

The ascender has an issue:

![](assets/2019-03-28-13-41-49.png)

![](assets/2019-03-28-13-44-06.png)

## ve-cy

Inflected curve:

![](assets/2019-03-28-13-47-00.png)

![](assets/2019-03-28-13-48-15.png)

## ze-cy

(Almost certainly) unintended curve upwards:

![](assets/2019-03-28-13-49-19.png)

![](assets/2019-03-28-13-50-14.png)

## ii-cy

Unintended upwards-handles.

![](assets/2019-03-28-13-51-24.png)

The bold looks better:

![](assets/2019-03-28-13-51-49.png)

So:

![](assets/2019-03-28-13-56-45.png)

### komije-cy

Ouch:

![](assets/2019-03-28-14-03-53.png)

Better:

![](assets/2019-03-28-14-04-50.png)


### Chi

These feet aren't suppose to be angled so sharply:
![](assets/2019-03-28-14-11-13.png)

In Fira Mono, you can see that the angle simply becomes less steep:

![](assets/2019-03-28-14-13-00.png)


So:

![](assets/2019-03-28-14-13-32.png)

### kaiSymbol

Not-quite-vertical strokes:

![](assets/2019-03-28-14-17-52.png)

Straightened in Bold & Reg:

![](assets/2019-03-28-14-18-46.png)

### betaSymbol

These lines aren't supposed to intersect:

![](assets/2019-03-28-14-20-11.png)

![](assets/2019-03-28-14-21-39.png)

### Nine

![](assets/2019-03-28-14-24-45.png)

![](assets/2019-03-28-14-25-49.png)

(similar problem in /nine.tosf)


### asciitilde_greater.liga

Broken connection on right side:

![](assets/2019-03-28-14-50-52.png)

![](assets/2019-03-28-14-51-33.png)

### asciitilde_asciitilde_greater.liga

Broken connection on right side:

![](assets/2019-03-28-14-51-48.png)

I've just scooted the curvy thing towards the arrow by a bit.

![](assets/2019-03-28-14-52-48.png)

### uniE0A0

Broken connection:

![](assets/2019-03-28-14-53-56.png)

Fixed:

![](assets/2019-03-28-14-54-14.png)

### r.001

![](assets/2019-03-28-14-56-15.png)

![](assets/2019-03-28-14-56-24.png)

### ae

This curve isn't quite continuous:

![](assets/2019-03-28-14-58-50.png)

I've made it a little more graceful:

![](assets/2019-03-28-15-00-36.png)

![](assets/2019-03-28-15-00-56.png)

### "Incorrect smooth connections" in several glyphs:

Like these slight kinks:

![](assets/2019-03-28-13-58-48.png)

Should be this:

![](assets/2019-03-28-13-58-57.png)

============================================================

## (Small) issues I'm leaving

Often, crossbars have unnecessary points. These aren't really needed for the shapes and add a very small amount of data, but they're harmless, so I won't remove them right now.

![](assets/2019-03-27-13-38-30.png)


---

There are many instances of overlapping shapes that, while technically fine, might not render absolutely perfectly. I'll leave these, however, as they will probably bother no one.

![](assets/2019-03-28-13-39-03.png)

---

Small inflections, or semi-vertical handles that clearly should be that way:

![](assets/2019-03-28-14-01-13.png)

---

Some curvy shapes have slight issues around smooth connections. I'm looking at intermediate weights to make sure there aren't huge kinks (which is a concern in angled curve points), but otherwise mostly leaving these.

![](assets/2019-03-28-14-10-07.png)