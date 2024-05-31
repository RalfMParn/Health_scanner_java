public class Controller {
    public Controller(Model model, View view) {
        view.registerButtonOpen(new ButtonOpenListener(model, view));
        view.registerButtonShow(new ButtonShowListener(model, view));
    }
}
