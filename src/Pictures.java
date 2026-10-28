// PART A
import javafx.scene.paint.Color;

enum Stripes { VERTICAL, HORIZONTAL }

record Tricolor(Stripes stripes, String first, String second, String third) {}

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
// creates a disc for japan
Img disc(int unit){
    int radius = ((unit * 3) / 5);
    String fill = "solid";
    return Img.circle(radius, fill, "red");
}

Img japan(int unit){
    int height = 2 * unit;
    int width = 3 * unit;
    String fill = "solid";
    Img disc = disc(unit);
    Img whiteRectangle = Img.rectangle(width, height, fill, "white");
    return Img.overlay(disc, whiteRectangle);
}

// PART B

// returns drawn image according to Stripes orientation
Img draw(Tricolor t, int unit){
    return switch(t.stripes){
        case VERTICAL -> vertical(unit, t.first, t.second, t.third);
        case HORIZONTAL -> horizontal(unit, t.first, t.second, t.third);
    };
}

// turns a flag around
Tricolor turned(Tricolor t){
    return switch(t.stripes){
        case VERTICAL -> new Tricolor(Stripes.HORIZONTAL, t.first, t.second, t.third);
        case HORIZONTAL -> new Tricolor(Stripes.VERTICAL, t.first, t.second, t.third);
    };
}

// PART C

// returns image but with with the first and third color blended for the second
Img blend(Color first, Color third, int unit){
    int height = 2 * unit;
    int width = unit;
    String fill = "solid";
    return Img.beside(
        Img.rectangle(width, height, fill, first), 
        Img.beside(
            Img.rectangle(width, height, fill, first.interpolate(third, 0.5)), 
            Img.rectangle(width, height, fill, third))
    );
}

void main(){
    // Part A
    // Check vertical
    Img France = vertical(30, "blue",    "white", "red");
    Img Ireland = vertical(30, "green", "white", "orange");
    
    Check.is(Img.width(Ireland), 90);
    Check.is(Img.height(France), 60);

    // Check horizontal
    Img Germany = horizontal(18, "black", "red", "gold");
    Img Armenia = horizontal(40, "red", "blue", "gold");
    Check.is(Img.width(Germany), 90);
    Check.is(Img.height(Armenia), 120);

    // Check disc & japan
    Check.is(Img.width(disc(30)), 36);
    Check.is(Img.width(disc(22)), 26); //26.4 but it drops the .4
    Check.is(Img.width(japan(30)), 90);
    Check.is(Img.width(japan(25)), 75);
    
    // Part B
    Tricolor france = new Tricolor(Stripes.VERTICAL, "blue", "white", "red");
    Tricolor germany = new Tricolor(Stripes.HORIZONTAL, "black", "red", "gold");
    
    // Check draw 
    Check.is(Img.width(draw(france, 10)), 30);
    Check.is(Img.width(draw(germany, 10)), 50);

    // Check turned
    Check.is(turned(france), new Tricolor(Stripes.HORIZONTAL, "blue", "white", "red"));
    Check.is(turned(germany), new Tricolor(Stripes.VERTICAL, "black", "red", "gold"));

    Check.done();
    
    // Part C

    // Check blend should be purple
    Img.show(blend(Color.RED, Color.BLUE, 30)); //  it is purple, idk how to write a check for that though

    // Check the other flags
    Img.show(France);
    Img.show(Ireland);
    Img.show(Germany);
    Img.show(Armenia);
    Img.show(draw(france, 40));
    Img.show(draw(germany, 40));
    Img.show(draw(turned(france), 40));
    Img.show(draw(turned(germany), 40));
}