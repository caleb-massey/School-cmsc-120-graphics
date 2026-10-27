// creates a flag of 3 vertical lines, it's size is determined by unit, 
// color by first, second, third
Img vertical(int unit, String first, String second, String third){
    int height = 2 * unit;
    int width = unit;
    String fill = "solid";
    return Img.beside(
        Img.rectangle(width, height, fill, first), 
        Img.beside(
            Img.rectangle(width, height, fill, second), 
            Img.rectangle(width, height, fill, third))
    );
}

// creates a flag of 3 horizontal lines, it's size is determined by unit, 
// color by first, second, third
Img horizontal(int unit, String first, String second, String third){
    int height = unit;
    int width = 5 * unit;
    String fill = "solid";
    return Img.above(
    Img.rectangle(width, height, fill, first), 
    Img.above(
        Img.rectangle(width, height, fill, second), 
        Img.rectangle(width, height, fill, third))
    );
}

void main(){
    // Check vertical
    Img France = vertical(30, "blue",    "white", "red");
    Img Ireland = vertical(30, "green", "white", "orange");
    
    Check.is(Img.width(Ireland), 90);
    Check.is(Img.height(France), 60);

    // Check horizontal
    Img Germany = horizontal(18,    "black", "red", "gold");
    Img Armenia = horizontal(30, "red", "blue", "gold");
    Check.is(Img.width(Germany), 90);
    Check.is(Img.height(Armenia), 90);





    Check.done();
    Img.show(Germany);
}