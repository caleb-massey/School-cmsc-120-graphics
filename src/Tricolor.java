// a flag of three stripes side by side, green, white and red, each 30 by 60
Img tricolor() {
    return Img.beside(Img.rectangle(30, 60, "solid", "green"),
                      Img.beside(Img.rectangle(30, 60, "solid", "white"),
                                 Img.rectangle(30, 60, "solid", "red")));
}

void main() {
    Check.is(Img.width(tricolor()), 90);
    Check.is(Img.height(tricolor()), 60);
    Check.done();
    Img.show(tricolor());
}
