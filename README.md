#DogRegister
A simple terminal-based dog register written in Java. The program allows users to manage dogs and owners through various text commands.

#Commands
-REGISTER NEW OWNER - Adds a new dog owner to the register.
-LIST OWNERS -  Shows all the added owners.
-REMOVE OWNER - Removes an already added owner from the register.
-REGISTER NEW DOG - Adds a new dog to the register.
-REMOVE DOG - Removes an already added dog from the register.
-LIST DOGS - Shows all the added dogs.
-INCREASE AGE - Increases a registered dog's age by 1.
-GIVE DOG TO OWNER - Assigns a registered dog to a registered owner.
-REMOVE DOG FROM OWNER - Removes a registered dog from a registered owner.
-EXIT - Terminates the program.

#Technologies used
-Java
-Object oriented programming
-ArrayList
-Array
-Scanner
-Comparator (interface)

#Use example
Enter command?> Register new owner
Enter owner name?> Adrian
The owner Adrian has been added to the register

Enter command?> Register new dog
Enter dog name?> Max
Enter dog breed?> Labrador
Enter dog age?> 8
Enter dog weight?> 30
The dog Max has been added to the register.

Enter command?> Give dog to owner
Enter dog name?> Max
Enter owner name?> Adrian
The dog Max is now owned by Adrian

Enter command?> List dogs
Enter minimum tail length?> 1
Name      Breed       Age    Weight    Tail   Owner
====================================================
MAX     LABRADOR     8     30      24.0      ADRIAN

Enter command?> 
