# BootlegGBASaveExtractor
BootlegGBASaveExtractor is a Save extractor for bootleg GBA Cartridges. This tool runs on JAVA.
This tool is able to extract save data from mystery dungeon, emerald and Fire Red for now. Untested in any other games yet, but support for them might be added later on.
After extracted, your sav can be used (i.e.) on PKHEX or on a clean original (non bootleg) ROM.

# Usage Notes
-This tool is for those GBA carts that save to the rom chip itself, if your bootleg uses a battery, this tool wont do much.
-You'll need to dump your bootleg rom, you can do that using a phisical rom dumper or a Nintendo DS homebrew. (Dump only the rom, The save data that gets dumped from these is usually filled with garbage data, and your actual save data is stored inside the rom, which this tool extracts(or at least tries to)).
-Make sure to put your rom inside a folder on your hard drive, with no other sav file in the same patch/folder.
-Open this tool, load your rom and select "extract .sav data". When the tool has finished, you will find your .sav file in the same directory as your ROM, usually as a file called "yourromnamehere.gba.sav" with 64kb.
-Just move and rename the save file to the same folder as your clean rom and have fun!
