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

Img row3(Img i){
    return Img.beside(i, Img.beside(i, i));
}

// returns grid of nine of the image given
Img grid3(Img i){
    return Img.above(row3(i), Img.above(row3(i), row3(i)));
}

Img quad(Img a, Img b){
    Img top = Img.beside(a, b);
    Img bottom = Img.beside(b, a);
    return Img.above(top, bottom);
}


// reutrns checker pattern, with the amount double the sides
Img checker2(int side){
    Img white = Img.square(side, "solid", "white");
    Img black = Img.square(side, "solid", "black");
    return quad(black, white);
} 


void main(){
    // Check grid3
    Check.is(Img.width(grid3(tricolor())), 270);
    Check.is(Img.width(grid3(armenia(20))), 240);

    Check.is(Img.height(grid3(tricolor())), 180);
    Check.is(Img.height(grid3(armenia(20))), 180);

    Check.is(Img.width(checker2(10)), 20);



    Check.done();
    Img.show(grid3(tricolor()));
    Img.show(grid3(armenia(20)));
    Img.show(checker2(10));
}