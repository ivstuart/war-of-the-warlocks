h2. Introduction

War of the Warlocks is a computer game designed back in 1993. The game has two wizards who face off against each other and try to destroy their opponent.
They use spells to reduce each other's health or other attributes. Each wizard starts with a certain amount of mana which regenerates over time. This mana is used to power spell casting.
Spells can be cast of different types and of various power levels from level 1-5. Defensive spells either absorb part of the level of an attack spell or reflect part of the level back towards the caster.

h2. History

The first version of WOTW was designed and coded by a single developer back in 1993. The language used was AMOS and the graphics were drawn using DeluxPaint4.
The interface with the game was via joysticks and the fire button was held to power up spells and a direction was used to select from the 8 types of spells.
Hence a total of 40 spells existed in the original design.

Spells and wizards were animated and sound effects were used for casting and the death of a wizard. Later came a QBASIC version with line drawings but complete with the essence of the game mechanics.

In 2004 a Java version of the game was written and graphics were all drawn from scratch using MS paint. Some of the graphics were animated using a graphics editor to create animated png files.
The main attack spell at level 4 was set to spin and the lightning effect attack spell at level 2 was animated to scroll.
2011 the code was refactored and updated to the latest java version of the time.

Most recently in 2024 the graphics has been updated in part by leveraging the drawing capability of the co-pilot ai preview tool free with windows 11.
MS paint and basic picture editing available on windows has been used to make the graphics background transparent or to tweak stray pixels.

h2. Game Mechanics

Each wizard has a set of attributes. Health, mana and power. Spells can be cast from level 1-5 and have a minimum casting cost.
If you exceed the power limit then you self-destruct, so be very careful when attempting to cast level 5 spells.

h3. Attack Spells

|| Level || Description || Effect ||
| 1 | Small red fireball | 5 damage |
| 2 | Small lightning bolt | 10 damage |
| 3 | Tornado | 20 damage |
| 4 | Boulder | 35 damage |
| 5 | Blue and red 8 pointed spinner | 50 damage |

h3. Defensive Spells

|| Level || Description || Damage || Absorb || Reflect ||
| 1 | blue small "[" | 1 damage | 1 | 0 |
| 2 | multi-coloured "<" | 2 damage | 1 | 1 |
| 3 | green "{" | 3 damage | 2 | 1 |
| 4 | white and blue prism | 4 damage | 0 | 2 |
| 5 | Solid large "c" | 5 damage | 1 | 2 |

h3. Other spells effect from original version

1. Poison over time - continuous damage of various strengths
2. Cure poison.
3. Shield - blocks next hit only
4. Shield - blocks up to 8 levels of spells until depleted
5. Double effect next spell hit
6. Instant death chance
7. Health drain - vampiric effect you gain health if hit.
8. Mana drain
9. Power drain
10. Power swap
11. Power boost
12. Lower magical resistance
13. Direct damage - considered cheating by some

h2. Notes about the original AMOS version

This had a map where you could choose which wizard opponent to face with a boss at the end. The opponent wizards had different attributes and styles of casting logic.
The map and background was rendered using a landscape drawing program call vista.

h2. Future work ideas

Increase the number of available spells to 40 to match the original with all new graphics and sounds for this.
Add a network mode to allow friends to play remotely against each other
Add required framework to deploy on steam
Add controller interface so that hand held device can be used to control the wizards
Enhance computer player logic and tactics
High score table
More levels of spell
Remove any bugs in the code and clean the code up to modern standard in 2024
Better wizard death animations
More animal spells - or different types of class of wizard. Druid etc..
Cross over or mash up of this game with other game types
Three dimensional version