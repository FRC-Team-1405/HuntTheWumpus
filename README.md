# HuntTheWumpus
A recreation of the 'Hunt the Wumpus' used to teach new students basic programming.

# [Hunt the Wumpus](https://en.wikipedia.org/wiki/Hunt_the_Wumpus)

> Hunt the Wumpus is a text-based adventure game developed by Gregory Yob in 1973. In the game, the player moves through a series of connected caves, arranged as the vertices of a dodecahedron, as they hunt a monster named the Wumpus. The turn-based game has the player trying to avoid fatal bottomless pits and "super bats" that will move them around the cave system; the goal is to fire one of their "crooked arrows" through the caves to kill the Wumpus. Yob created the game in early 1973 due to his annoyance at the multiple hide-and-seek games set in caves in a grid pattern, and multiple variations of the game were sold via mail order by Yob and the People's Computer Company. The source code to the game was published in Creative Computing in 1975 and republished in The Best of Creative Computing the following year.

The player is told what room they are in and what rooms and where the tunnels lead

```
You are in room 1 
Tunnels lead to         5       8       2
Shoot or Move? (S/M) 
```

The player is warned when they are near a hazard. (Bat / Pit / Wumpus)

```
Bats nearby...
You feel a draft...
You smell a horrid stench...
```

When shooting and arrow the player decide how far it will travel (1 - 5) and the path it will take by listing the rooms. If path to a room is invalid the arrow will pick a path at random. Warning the arrow could fly back and hit the player.

If you fire an arrow it might wake up the Wumpus. A Wumpus that is awake may or may not move to a different room. The Wumpus cannot fall into the pits or be carried by bats. If it enters the same room as the player, it will eat the player.

#[Original sample run](https://www.atariarchives.org/bcc1/showpage.php?page=248)

```
***
INSTRUCTIONS (Y-N)?Y
WELCOME TO 'HUNT THE WUMPUS'

THE WUMPUS LIVES IN A CAVE OF 20 ROOMS: EACH ROOM HAS 3 TUNNELS LEADING TO OTHER
ROOMS. (LOOK AT A DODECAHEDRON TO SEE HOW THIS WORKS. IF YOU DON'T KNOW WHAT A
DODECAHEDRON IS, ASK SOMEONE)

***
HAZARDS:

BOTTOMLESS PITS - TWO ROOMS HAVE BOTTOMLESS PITS IN THEM
IF YOU GO THERE: YOU FALL INTO THE PIT (& LOSE!)

SUPER BATS  - TWO OTHER ROOMS HAVE SUPER BATS. IF YOU GO THERE, A BAT GRABS YOU
AND TAKES YOU TO SOME OTHER ROOM AT RANDOM. (WHICH MIGHT BE TROUBLESOME)

WUMPUS:

THE WUMPUS IS NOT BOTHERED BY THE HAZARDS (HE HAS SUCKER FEET AND IS TOO BIG FOR
A BAT TO LIFT). USUALLY HE IS ASLEEP. TWO THINGS WAKE HIM UP: YOUR ENTERING HIS
ROOM OR YOUR SHOOTING AN ARROW.

IF THE WUMPUS WAKES, HE MOVES (P=0.75) ONE ROOM OR STAYS STILL (P=0.25). AFTER
THAT, IF HE IS WHERE YOU ARE, HE EATS YOU UP (& YOU LOSE!)

YOU:

EACH TURN YOU MAY MOVE OR SHOOT A CROOKED ARROW 
MOVING: YOU CAN GO ONE ROOM (THRU ONE TUNNEL)
ARROWS: YOU HAVE 5 ARROWS. YOU LOSE WHEN YOU RUN OUT.

EACH ARROW CAN GO FROM 1 TO 5 ROOMS: YOU AIM BY TELLING THE COMPUTER THE ROOMS
YOU WANT THE ARROW TO GO TO. IF THE ARROW CAN'T GO THAT WAY (IE NO TUNNEL) IT
MOVES AT RANDOM TO THE NEXT ROOM.

IF THE ARROW HITS THE WUMPUS: YOU WIN.

IF THE ARROW HITS YOU: YOU LOSE.

WARNINGS:

WHEN YOU ARE ONE ROOM AWAY FROM WUMPUS OP HAZARD, THE COMPUTER SAYS:

WUMPUS - 'I SMELL A WUMPUS'

BAT - 'BATS NEARBY'

PIT - 'I FEEL A DRAFT'

***
HUNT THE WUMPUS

BATS NEARBY!

YOU ARE IN ROOM 2
TUNNELS LEAD TO 1 3 10

SHOOT OR MOVE (S-M)? M
WHERE TO? 1
ZAP -- SUPER BAT SNATCH! ELSEWHEREVILLE FOR YOU!

YYYIIIIEFEE . . . FELL IN PIT
HA HA HA - YOU LOSE!

SAME SET UP (Y-N)?Y
HUNT THE WUMPUS

BATS SUPERBATS PUT ME IN A PIT SOMEWHERES

BATS NEARBY!

YOU ARE IN ROOM 2
TUNNELS LEAD TO 1 3 10
SHOOT OR MOVE (S-M)?M
WHERE TO?3
YOU ARE IN ROOM 3
TUNNELS LEAD TO 2 4 10
```