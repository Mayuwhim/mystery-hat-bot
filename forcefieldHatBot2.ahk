; Forcefield Hat AHK Script
; By Hoioidoi (Mayuwhim)
; May 31, 2023

#MaxThreadsPerHotkey 2
InputBox, Text, Hello, Enter something to continue
Return

F1::
MouseClick, left, 900, 620 ; change these to location of take bingo card button
sleep 727
MouseClick, left, 900, 620
sleep 727
MouseClick, left, 900, 620
sleep 727
MouseClick, left, 900, 620
sleep 727
send {2 down} 
sleep 100
send {2 up}
sleep 500
send {2 down}
sleep 100
send {2 up}
sleep 500
Return