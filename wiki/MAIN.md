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


## Known Issues

1. Crash in Oreo when widget is being updated.
2. Widget not updating for async/polling component.
3. Camera doesn't work with self-signed ssl cert.
4. Crash when trying to open Edit Dashboard [can't reproduce]
5. Sort by Order not working after modified. [can't reproduce]


## Advertisement Policy

1. I'm running a test on the admob system from 1st to 14th of Nov.
	- Banner ads will run from 1st to 7th, and
	- Interstitial ads will run from 8th to 14th.
2. Why now? From the stats, I found that at the moment the app has a good mix of users from around the world. I need the stats from admob to understand some calculations.
3. I know the ads is an eyesore and it frustrates everyone. But please bear with me, I have no intention to run it for long term and promise to turn it off after 14th.


## Contributions

1. For developers, you can contribute your custom control via this repo: https://github.com/axzae/homeassist-builder
2. If you would like to help out on localization, please contact support@axzae.com.
3. Special shout-out to Никита Якунин for Russian translation and Paul de Wit for Dutch translation.

