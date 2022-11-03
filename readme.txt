# Basic  #

## Part 1 ##
I have implemented the classes Character(with implemented Comparable interface) and Team following the coursework specification.
I have added the Toolbox class additionally (for the purpose of getting random integer).

Additional methods are added to the Character class accordingly to check whether the Character has above 40% HP,
whether the character is alive, to flip a coin(for a random generator) and to compare the speed of the characters.

Additional methods are added to the Team class accordingly to remove members from the team, to return the character array list,
to return the team size, to get random member from the team, to check whether thee are any alive members in the team that
are not the chosen member, to get the member of the team with the least HP and to check whether the team is dead.

## Part 2 ##
I have implemented the classes Student, AIStudent, CSStudent, CyberStudent, SEStudent following the coursework specification.

I have added additional methods to Student class to check whether the student has maximum KP.

## Part 3 ##
I have implemented the classes Minion and Boss and the interface Monster following the coursework.

For both Minion and Boss I have used the Toolbox class to get random number between 1 and 100 to decide
which attack they should perform.

## Part 4 ##
I have implemented the classes StudentTeam, MonsterTeam and Guild following the coursework.
The move methods in them check what type of student or monster the character is and defines a diffrent strategy.

The strategy for the different students is as folllows.

- *AIStudent*: The method checks whether the student has Max KP and is Alive(1st check). If the 1st check passes than
the method checks whether the student has more than 40% of his HP(2nd check). If the 2nd check passes than the student
uses Machine Learning on the enemy with the lowest HP. If the 2nd check doesn't pass than the student uses Natural Language
Processing. If the 1st check doesn't pass the method does another check whether the student has more than 40% HP and is Alive
if that passes then the student uses Java Programming on the enemy with the least HP, if it doesn't, it checks whether the student is Alive and uses Self Study.
If nothing passes than the method returns that the student is dead. 

- *CSStudent*: The method checks whether the student has Max KP and is Alive(1st check). If the 1st check passes than
the method loops through the team to get the first friend below 40% HP and uses support on him. If there are no friends
below 40% HP and there are alive friends than the student uses Pair Working with random friend. If the 1st check doesn't pass 
the method does another check whether the student has more than 40% HP and is Alive, if that passes then the student uses 
Java Programming on the enemy with the least HP, if it doesn't, it checks whether the student is Alive and uses Self Study.
If nothing passes than the method returns that the student is dead. 

- *CyberStudent*: The method checks whether the student has Max KP and is Alive(1st check). If the 1st check passes the student
uses Cyber Attack on the enemy team. If the 1st check doesn't pass the method does another check whether the student has 
more than 40% HP and is Alive, if that passes then the student uses Java Programming on the enemy with the least HP, if it doesn't, it checks whether 
the student is Alive and uses Self Study. If nothing passes than the method returns that the student is dead. 

- *SEStudent*: The method checks whether the student has Max KP and is Alive and there are other team mates alive(1st check).
If the 1st check passes a counter is created to check how many members of the team are below 40% HP. If more than counter is
greater than half of the team, the student uses Group Discussion, if not, the student uses Group Work on the enemy with the
least HP. If the 1st check doesn't pass the method does another check whether the student has more than 40% HP and is Alive, 
if that passes then the student uses Java Programming on the enemy with the least HP, if it doesn't, it checks whether 
the student is Alive and uses Self Study. If nothing passes than the method returns that the student is dead. 

For the Monster team the method checks what type of monster the character is and uses the appropriate strike method.

For the Guild class I have used Toolbox.

Additional methods are added to the Guild class accordingly to check whether the guild has alive members.
The getTeam method is returning a team formed by random members of the guild.

## Part 5 ##
I have implemented the class Battle following the coursework

The class Battle gets two teams. The fight method starts a loop that represents the rounds. In the beggining of each round
a new array list is created with the alive battle participants and is sorted accordingly to the speed of the members.
Then every member uses their move method. Before the end of the loop, it checks whether one of the teams is dead and if so
returns the other team as a winner. If after 30 rounds there is no winner, the battle result is null(which represents a tie).

## Part 6 ##
I have implemented the class TowerOfMonsters following the coursework and i have also implemented additional Game Reader class.

The Game Reader class takes a file and contains the following methods: getLine() - to read a single line from the file,
fileIsRead() - to check whether the file is ready to be read and addToTeam(String line) - to read the monsters on each line
and add them to the Monsters Team for each level.

The TowerOfMonsters class creates a new guild with 8 students(2 for each class) and generates a team from the student guild
then for each level(line) from the file it starts a battle between the student team and the current monster team. If the monster
team wins and there are no alive students, a message is printed that ends the game.

# Extension #
I have implement the following extension.

Three new classes Students that are added to the student team and the StudentTeam class has been extended.
BEEStudent(Biomedical Electronic Engineering Student), EEStudent(Electrical Engineering Student) and AEEStudent(Aerospace Electronic Student)

The BEEStudent method allows him to deal damage to an enemy and heal a friend for the same amount of damage at the same time.
The EEStudent method allows him to deal damage to up to two alive members of the enemy team.
The AEEStudent method allows him to instantly kill an enemy.

The strategy for the different students is as folllows.

- *BEEStudent*: The method checks whether the student has Max KP, is Alive and has Alive team mates(1st check). If the first
check passes the student uses Biomedical Engineering with a random team member on the enemy with the least HP. If the 1st check 
doesn't pass the method does another check whether the student has more than 40% HP and is Alive, if that passes ,then the student
uses Java Programming on the enemy with the least HP, if it doesn't, it checks whether the student is Alive and uses Self Study. 
If nothing passes than the method returns that the student is dead.

- *EEStudent*: The method checks whether the student has Max KP and is Alive(1st check). If the first check passes the student uses
Electrical Strike on the enemy team. If the 1st check doesn't pass the method does another check whether the student has more than 
40% HP and is Alive, if that passes ,then the student uses Java Programming on the enemy with the least HP, if it doesn't, it checks
whether the student is Alive and uses Self Study. If nothing passes than the method returns that the student is dead.

- *EEStudent*: The method checks whether the student has Max KP and is Alive(1st check). If the first check passes the method loops over
the enemy team and finds an alive Boss monster. Than the student uses Rocket Strike on the Boss monster. If there are no alive Boss
monsters than the student uses Rocket Strike on the first alive enemy. If the 1st check doesn't pass the method does another check whether
the student has more than 40% HP and is Alive, if that passes ,then the student uses Java Programming on the enemy with the least HP, if it 
doesn't, it checks whether the student is Alive and uses Self Study. If nothing passes than the method returns that the student is dead.

To use the extention just add the new student files into the src or the folder with the java files and replace the StudentTeam file.
If you want you can add the new classes into the guild for the Tower Of Monsters game.