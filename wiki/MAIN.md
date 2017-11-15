# HomeAssist

This will be the HomeAssist wiki page. You can help to update by modifying this file in GitHub.

## What's in Progress?

I keep track stuffs in [trello](https://trello.com/b/C0YnMv3L/homeassist). At the moment, my focus is to inroduce card view mode as an alternative for the current tile view.
This is to support the display of subGroup which currently I can't find a way to display properly using tile.

## FAQs

### How many interaction points are there for a tile?

There are two, single click and long click. Single click tends to toggle stuffs. long click usually brings up advance dialog.

### How to close HomeAssist app?

To gracefully exit HomeAssist after use, press back button twice. If you use the home button, you may require to disconnect websocket manually via notification.

<img width='380' src='https://raw.githubusercontent.com/axzae/homeassist-builder/master/wiki/websocket_notification.png'/>

## Supported Components

* switch
* light
* automation
* script
* group
* media_player
* input_select
* input_slider | input_number
* input_boolean
* input_text
* input_datetime
* sensor
* binary_sensor
* device_tracker
* sun
* climate
* camera

## Known Issues

1. Widget crashes and not updating for async/polling component.
2. Crash in Oreo when widget is being updated.
3. Protocol Exception

## Contributions

1. For developers, you can contribute your custom control via this repo: https://github.com/axzae/homeassist-builder
2. If you would like to help out on localization, please contact support@axzae.com.
3. Special shout-out to Никита Якунин for Russian translation and Paul de Wit for Dutch translation.

