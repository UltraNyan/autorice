# AutoRice
Graphical utility to edit and manage your config files without getting your hands dirty with text editors.
The goal is to provide color pickers and other widgets instead of manually modifing hex codes in text fies.

For example, lets make a hex color in awesome wm theme editable by AutoRice. First open up the ```rice.xml``` and insert the location of the file in your home directory.
```
<?xml version="1.0"?>
<files>
	<file>/.config/awesome/themes/holo/theme.lua</file>
</files>
```
Then open the file itself and add a new comment after the hex color(in this example we are using lua commenting syntax). The programm reads the data after the keyword "AutoRice" as an comment.
```
theme.fg_normal = "#369d34" --AutoRice Foreground color
```
Autorice will find hex color and make it into a GUI widget you can click on and edit.

##Current progress so far:

A working user interface with save function and reset to last save stated. Also working native color selectors.

![alt tag](https://raw.githubusercontent.com/UltraNyan/autorice/master/Screenshots/shot1.png)

##Future Plans
Replace xml editing with file selector and automatic conf file creation
Add support for sqllite database for editing firefox userstyles from Autorice
Write unit tests, ayy I never test my code, but when I do, I'll do it in production.


