Homeassist-builder
==================

[![Build Status](https://travis-ci.org/axzae/homeassist-builder.svg?branch=travisci)](https://travis-ci.org/axzae/homeassist-builder)


Template for building custom control for HomeAssist app


## Quick Start
1. Create a new Class in `fragment.control` package. The class must extends `BaseControlFragment`.
2. Put your `new_entity.json` in `/assets` directory.
3. In `MainActivity.showEntityAction()`, get entity instance with `new_entity.json`.
4. Make necessary changes in the switch statement.
5. Run!
6. Make a push request or inform me via email.
 
## Download

Download HomeAssist on Google Play:

<a href="https://play.google.com/store/apps/details?id=com.axzae.homeassistant">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>


# Requirements

HomeAssist Builder requires Android Studio 3.0 Beta 7

# Thanks

[List of Contributors here]

# License

    Copyright (C) 2017 Axzae

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.