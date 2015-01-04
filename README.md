APCSProject: Scrabble
===========


Work Assignment:
--------------

1. Tiles
		* Assign a point value for certain letters
		* Blank tiles (probably brings up message to press a key to
        assign a letter)
		* GUI - Make them draw themselves
2. Tile places
		* Modifiers (triple letter, double word, etc)
		  - Modifiers can only be used once (probably use a boolean)
		* GUI - Make them draw themselves
3. Players
		* Score will be kept by a player int variable.
		* Scoring will be a player method. However, it will call the
        tile places as well as the tiles to make the score



Scoring:
------
Scoring is a bit complicated. It takes all of the possible words made
using the tiles. For example, if the board looks like this:

H E L L O

And you add your tiles, making:


A H A
H E L L O

You're not only making the word AHA, but also AH, HE and AL. I think
we can use the idea of a "spent" tile place to figure out which words
to count. Every word that has an "unspent" tile is counted, while
every other word is not. 
