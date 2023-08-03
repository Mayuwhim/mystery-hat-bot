; Forcefield Hat AHK Script V2
; By Hoioidoi (Mayuwhim)
; August 08, 2023

#MaxThreadsPerHotkey 2
InputBox, Text, Hello, Enter something to continue
Return

F1::
MouseClick, left, 900, 620 ; change these to location of take bingo card button
sleep 727
MouseClick, left, 900, 620
sleep 37272
MouseClick, left, 900, 620
sleep 727
MouseClick, left, 900, 620
sleep 727
send {2 down} 
sleep 200
send {2 up}
sleep 727
send {2 down}
sleep 200
send {2 up}
sleep 727
Return

P::
ExitApp
Return