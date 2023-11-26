## LDTS_1105 - CrossingGuardJoe

> Get ready for the ultimate adrenaline rush in this action-packed arcade adventure as Crossing Guard Joe!  
> Brace yourself for the chaotic streets of Gotham City, where you'll battle unruly drivers.  
> This game demands lightning-fast reflexes and razor-sharp decision-making. The drivers show no mercy—they won't stop for anything, putting your quick thinking to the ultimate test as you navigate the kids to safety.  
> Your score? It's all about how many kids you guide across the street. Master each level, fine-tune your strategies, and race to claim the top spot on the pulsating LEADERBOARD.  
> Ready to push your crossing guard skills to the limit?  
> Enter the game and show 'em who's boss!

This project was developed by Bruno Huang (up202207517@fe.up.pt) and Ricardo Yang (up202208465@fe.up.pt) for LDTS 2023⁄24.

### IMPLEMENTED FEATURES

- **Player movement** - The game character (Joe) is able to move left or right when corresponding arrow key is pressed.
- **Player control** - A kid will start to move when Joe is near it (an arrow will appear pointing to the kid) and presses 'arrowUp' key, when 'arrowDown' key is pressed the kid stops moving.
- **Kid** - Kids are instantiated in a queue at the right sidewalk of the street, and they walk at a defined speed when Joe lets them walk.

### PARTIALLY IMPLEMENTED

- **Game over** - When hp reaches 0 game ends.
- **Car** - Cars are instantiated in a random road lane at the top side of the street, and they traverse the road in a unidirectional downward trajectory, the speed of a car increases by level.
- **Kid collision** - When a kid is hit, it goes with the car.

### PLANNED FEATURES

- **Menu** - Upon launching the application, a menu will be displayed presenting "START GAME", "LEADERBOARD", "INSTRUCTIONS" and "EXIT". When player selects "START GAME" it's shown difficulty options for it (e.g. "EASY", "MEDIUM", "HARD").
- **Player collision** - When Joe gets hit by a car, he is projected to either left or right side of the car.
- **Lives** - When a kid is hit by a car, player loses one hp. The amount of hp is decided when player chooses difficulty at the start of the game.
- **Score** - For every kid passing to the left sidewalk of the street player gets 100 points. If Joe gets hit by a car points are taken (quantity to be determined);
- **Leaderboard** - Players score and name are stored in a leaderboard file.
- **Power-ups** - Power-ups are generated at random intervals within the game environment. Upon Joe's acquisition of these power-ups, their effects are immediately manifested (e.g. "Freeze cars", "Kids speedup", "Double points", "Get 1 hp", etc).

### DESIGN

> This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts:

- **Problem in Context.** The description of the design context and the concrete problem that motivated the instantiation of the pattern. Someone else other than the original developer should be able to read and understand all the motivations for the decisions made. When refering to the implementation before the pattern was applied, don’t forget to [link to the relevant lines of code](https://help.github.com/en/articles/creating-a-permanent-link-to-a-code-snippet) in the appropriate version.
- **The Pattern.** Identify the design pattern to be applied, why it was selected and how it is a good fit considering the existing design context and the problem at hand.
- **Implementation.** Show how the pattern roles, operations and associations were mapped to the concrete design classes. Illustrate it with a UML class diagram, and refer to the corresponding source code with links to the relevant lines (these should be [relative links](https://help.github.com/en/articles/about-readmes#relative-links-and-image-paths-in-readme-files). When doing this, always point to the latest version of the code.
- **Consequences.** Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with those of alternative solutions.

#### CODE ORGANIZATION

**Problem in Context**

To enhance code readability and improve overall programming efficiency, we faced the task of drawing images and coding their movements. Consequently, a need arose to compartmentalize these tasks for better organization and clarity in the codebase.

**The Pattern**

We have applied the **MVC** pattern. To enhance readability and improve programming efficiency

**Implementation**

We organized the code into three distinct sections:
Model: Manages data related to image properties and movements.
View: Handles the drawing of images on the screen.
Controller: Manages user input and orchestrates the interaction between the Model and View for smooth image rendering and movement.

![](docs/CrossingGuardJoeUML.png)

These classes can be found in the following files:

- [Model](https://github.com/FEUP-LDTS-2023/project-l11gr05/tree/master/src/main/java/com/aor/CrossingGuardJoe/model)
- [View](https://github.com/FEUP-LDTS-2023/project-l11gr05/tree/master/src/main/java/com/aor/CrossingGuardJoe/view)
- [Controller](https://github.com/FEUP-LDTS-2023/project-l11gr05/tree/master/src/main/java/com/aor/CrossingGuardJoe/controller)

**Consequences**

The use of the MVC architectural pattern in the current design allows the following benefits:

- promotes a clear separation of concerns, allowing for modular development. The model, view, and controller components can be developed and modified independently, making the codebase more maintainable.
- increased code reusability. Models and views can be reused across different parts of the application, reducing redundancy.
- the separation of concerns makes it easier to test individual components.

#### KNOWN CODE SMELLS

> 1. Cars are currently generated in a wrong way, we think we should limit them to a certain number and do a deletion and regeneration as the cars move out of screen.  
> 2. Kids are currently not being controlled in a correct way, we need to change the way Joe controls them.  
> 3. Menu isn't shown as we expected to, so we need to find another way to draw the menu.  
> 4. We think we still need to implement a "collide checker" to write the code for car collision with either Joe or kids.  
> 5. Some parts of the code aren't in correct place.

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.

**Example**:

- John Doe: 40%
- Jane Doe: 60%
