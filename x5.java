// Justin Acosta
// X5: collisons.
// make a pool table with billard balls that collide.

String title= "X5 Pool Table";
String author= "Justin Acosta";
String help= "Press 'r' or left click to reset";


float cueX, cueY, cueDX, cueDY;
float redX, redY, redDX, redDY;
float yelX, yelY, yelDX, yelDY;
float bluX, bluY, bluDX, bluDY;

float top, bottom, left, right, middle;



// Set up.  Size.
void setup(){
  size( 700, 500);
  left= width/2 - 255;
  right= width/2 + 255;
  top= height/2 - 140;
  bottom= height - 106;
  middle= left + (right-left)/2;
  reset();
  
}

// starting postions of balls
void reset(){   
  cueX= width/2 -150;
  cueY= height/2;
  
  
  redX = random(right , middle);    redY = random(top, bottom);
  bluX = random(left, middle);      bluY= random(top, bottom);
  yelX = random(left, right);       yelY= random(top, bottom);
  
  //speed
  redDX = random(1,3);              redDY = random(1,3);
  bluDX = random(1,3);              bluDY = random(1,3);
  yelDX = random(1,3);              yelDY = random(1,3);
  cueDX = random(1,3);              cueDY = random(1,3);
}


void draw(){
  background(100, 150, 100 );
  rectMode(CENTER);
  table();
  billiards();
  info();
  move();
  bounce();
  collisions();


}


// Pool table and felt.
void table(){
  fill(0);
  rect(width/2, height/2, 600, 350);   // boarder
  fill(100, 0 ,0);
  rect(width/2, height/2, 550, 300);   //Felt
  
  
}


void billiards(){
  fill(255);          ellipse(cueX, cueY, 30, 30);   //Cue ball
  fill(255, 0, 0);    ellipse(redX, redY, 30, 30);  // Red ball
  fill(0, 0, 255);    ellipse(bluX, bluY, 30, 30);  //Blue ball
  fill(255, 255, 0);  ellipse(yelX, yelY, 30, 30);  //Yellow ball
  
  
}


void move(){
  
 redX = redX + redDX; 
 redY = redY + redDY;
  
 bluX = bluX + bluDX; 
 bluY = bluY + bluDY;
 
 yelX = yelX + yelDX; 
 yelY = yelY + yelDY;
 
 cueX += cueDX;
 cueY += cueDY;
 
 /*if (dist(cueX, cueY, redX, redY) < 30 ||
     dist(cueX, cueY, bluX, bluY) < 30 ||
     dist(cueX, cueY, yelX, yelY) < 30){         //Cue moves when hit by others
     cueX += cueDX;
     cueY += cueDY;                             //Not working as intended
     
    
   
 }
 */
 
 }



void bounce(){      //Bounce off boarder 
redX += redDX;      // redX += redDX is the same as saying redX = redX + redDX
if ( redX< left || redX> right ) redDX *= -1;

redY += redDY;  
if ( redY<top || redY>bottom ) redDY *=  -1;

bluX += bluDX;
if ( bluX < left || bluX > right) bluDX *= -1;

bluY += bluDY;
if (bluY < top || bluY > bottom) bluDY *= -1;

yelX += yelDX;
if (yelX < left || yelX > right) yelDX *= -1;

yelY += yelDY;
if (yelY < top || yelY > bottom) yelDY *= -1; 

cueX += cueDX;
if ( cueX < left || cueX > right) cueDX *= -1;

cueY += cueDY;
if ( cueY < top || cueY > bottom) cueDY *= -1;

}



void info(){
  textSize(20);
  fill(0);  text(author, 75, 45);
  fill(0);  text(title, 450, 475);
  textSize(15);
  fill(0);  text(help, 450, 45);
  
}

void collisions(){    //Balls bounce off each other
 float tmp;
 
 if (dist(redX, redY, yelX, yelY) < 30 ){      // Red and Yellow
   tmp = yelDX;  yelDX = redDX; redDX = tmp;
   tmp= yelDY;   yelDY = redDY; redDY = tmp;
 }
 
 if (dist(redX, redY, bluX, bluY) < 30){        // Red and Blue
   tmp = bluDX;   bluDX = redDX;  redDX = tmp;
   tmp = bluDY;   bluDY = redDY;  redDY = tmp;
 }
 
 if (dist(bluX, bluY, yelX, yelY) < 30){        // Blue and Yellow
   tmp = yelDX;   yelDX = bluDX;  bluDX = tmp;
   tmp = yelDY;   yelDY = bluDY;  bluDY = tmp;
 }
 if (dist(cueX, cueY, redX, redY) < 30){         // Cue and Red
   tmp = redDX;   redDX = cueDX;  cueDX = tmp;
   tmp = redDY;   redDY = cueDY;  cueDY = tmp;
 }
 if (dist(cueX, cueY, bluX, bluY) < 30){         // Cue and Blue
   tmp = bluDX;   bluDX = cueDX;  cueDX = tmp;
   tmp = bluDY;   bluDY = cueDY;  cueDY = tmp;
 }
 if (dist(cueX, cueY, yelX, yelY) < 30){         // Cue and Yellow
   tmp = yelDX;   yelDX = cueDX;  cueDX = tmp;
   tmp = yelDY;   yelDY = cueDY;  cueDY = tmp;
 }
}

void keyPressed(){
  
  if (key == 'r'){
    reset();
    
  }
}
  
  void mousePressed(){
    if (mouseButton == LEFT){
      reset();
    }
  }
  
