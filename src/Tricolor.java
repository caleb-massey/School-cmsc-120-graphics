// a flag of three stripes side by side, green, white and red, each 30 by 60
Img tricolor() {
    return Img.beside(Img.rectangle(30, 60, "solid", "green"),
                      Img.beside(Img.rectangle(30, 60, "solid", "white"),
                                 Img.rectangle(30, 60, "solid", "red")));

}

Img armenia(int unit){
    int height = unit;
    int width = 4 * unit;
    return Img.above(Img.rectangle(width, height, "solid", "red"), 
                     Img.above(Img.rectangle(width, height, "solid", "blue"), 
                               Img.rectangle(width, height, "solid", "orange")));
}

void main() {
    Check.is(Img.width(tricolor()), 90);
    Check.is(Img.height(tricolor()), 60);
    
    // Check armenia
    Check.is(Img.width(armenia(20)), 80);
    Check.is(Img.height(armenia(20)), 60);


    Check.done();
    Img.show(tricolor());
    Img.show(armenia(20));
}
