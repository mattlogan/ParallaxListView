ParallaxListView
================

A view class with a ListView and a parallaxed header

<img src="https://raw.githubusercontent.com/mattlogan/ParallaxListView/master/github-assets/parallax.gif" height="540"/>

### Get Started

Use a `ParallaxListView` where you'd normally use a `ListView`.

Call `setAdapter(ListAdapter adapter)` as you normally would.  Don't worry about the header.

Use the method `setHeaderDrawable(Drawable drawable)` to set a header image.

### To do:

1. Allow for a `ViewGroup` in the header view, but keep the `setHeaderDrawable(Drawable drawable)` method.
2. Publish to Maven Central.

### License

The MIT License (MIT)

Copyright (c) 2014 Matthew Logan

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
