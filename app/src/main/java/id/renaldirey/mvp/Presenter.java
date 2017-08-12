package id.renaldirey.mvp;

public class Presenter implements MainMVP.presenter{
    private final MainMVP.view view;

    public Presenter(MainMVP.view view){
        this.view = view;
    }

    @Override
    public void clickedButton(){
        Model model = new Model("Renaldi", "Male", 18);
        view.displayToast(model);
    }
}
