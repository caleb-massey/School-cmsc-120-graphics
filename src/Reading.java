// Runs one of the reading's programs, as the book prints it. They are in
// chap03/ and the folders beside it, one folder per section: chap03/sect7 is
// 3.7. To run another, change the name inside launch( ), and press Run.
//
// Run from their own main, they stop with "JavaFX runtime components are
// missing": Java looks for JavaFX before main runs, in a place this project
// does not put it. Started from here, they run.
void main() {
    javafx.application.Application.launch(chap03.sect7.RandomTricolorFlag.class);
}
