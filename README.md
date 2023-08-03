# mystery-hat-bot
For da amazing bunker simulator

Detects pixels to automate and optimize getting the forcefield hat

* Make sure your monitor is set to 1080p!! Or else you will need to run the source code with modified parameters
* Set zoom to 100, make sure taskbar exists and is on bottom
* You need a [JRE (Java Runtime Environment)](https://www.oracle.com/java/technologies/downloads/#jdk20-windows) for this

Credits to [kwhat's jnativehook](https://github.com/kwhat/jnativehook) for hotkey functionality

# Installation
1. Download `ForcefieldHatBot.jar` if you are on Windows 10, or `ForcefieldHatBotW11.jar` if Windows 11

     i) The only difference is the pixel locations as W11 taskbar is bigger

2. Download `ForcefieldHatBot_2.exe`

# How to Use
1. Open up DABS in windowed mode, maximized
2. Go to Mr Bingo Man
3. Get a bingo card, turn auto bingo off, move it to hotbar slot 2, UNEQUIP IT (but keep the cards on screen)
4. Position your camera so you can click on Mr Bingo Man [HERE](https://cdn.discordapp.com/attachments/401130434378989592/1113543650673168426/bingomoment.png), or the card printer
5. Open up the `ForcefieldHatBot_2.exe` first, follow the instruction
6. Making sure nothing except Roblox is obstructing the right side of the screen, open up the `.jar`
7. You should be set!

# How to Close
Press P to close both programs. You will need to click on the files again to reopen them.

# What if I don't have 1080p? / What if my screen doesn't line up?
You will need to download AutoHotKey and a Java IDE to edit the pixels being detected in the source code, then you can run it from there.

If you want hotkey functionality, you will also need **version 2.1** of jnativehook as an external jar library, otherwise just delete that part of the code

Screenshot your screen with the bingo cards out, paste it in paint or something that shows pixel locations

Zoom in, put the x values of the RED pixels in the first array, and the y values of the PURPLE pixels in the second array

[These pixels but on your own screenshot](https://cdn.discordapp.com/attachments/401130434378989592/1113543650673168426/bingomoment.png)

And update the AHK script click location for your take a bingo card button location
