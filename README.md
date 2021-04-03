# pong
building pong. at last. the essence of 2d games. am i worthy?

## latest progress

## set framerate/update rate

![pong gameplay, green ball](demos/demo3.gif)

I fixed a couple bugs, like the paddles going past the screen at times. this was happening because i had broken the separation of concerns of the different modules: i
was making changes to game model data in the input module. events happen on a separate thread in java and so were taking place despite the update method which is actually 
the place where the game world progresses. it took a while to figure that out, but im happy with the result. 

i set the framerate to 30 fps. itoyed around with moving rendering into a separate thread before realizing i could do the same thing right in main. ill eventually do a 
proper game loop, but this is fine for now, though it could stand some backbuffering to stop the flickering.

i also added pause and quit with p and q respectively. next i need to add win states and restarting.

pleased.

![pong gameplay, green ball](demos/demo2.gif)

so i have built pong. from scratch, off the top of my head. yesss. why was this such a big deal for me? well,
i see pong as the simplest expression of what a 2d game is. it has all the pieces of any more complex game, 
animation, multiple objects, collision detection, etc. if i add a computer player, then there'll be game ai.

i'll admit, there's a lot more to pong than meets the eye. i ended up giving the ball random y trajectories 
after colliding with the paddles. i read somewhere that the original game divided the paddle into sections 
and set the y trajectory based on where the ball made contact. i'd like to implement that at somepoint 
perhaps, but for now i'm excited to have the basic mechanics done. 

it'd be cool to add powerups or even random obstacles. that would almost require the addition of the 
intentional trajectories though because you'd need to be able to place the ball precisely in that case in 
order for it to be fair. so i need to figuire that part out.

wow. this is coool.

![static image of pong gamefield](demos/demo1.png)

this is like my capstone for n00bness 101 or something. i see pong as the most fundamental expression of a 2d game. this is my first time really attempting to implement it 
completely from my head, no tutorials, no videos, just feeling it out, using my code instincts. if i can build a complete implementation, suffice it to say, it will be a 
big deal to me personally. 

so far ive just built the window and defined the game objects: the paddles and the ball. ive added an input class to handle key presses. next will be to begin to work out 
the movement of the ball and its interactions with the edges.
