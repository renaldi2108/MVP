package id.renaldirey.mvp;

public interface MainMVP {
    interface view {
        void displayToast(Model model);
    }
    interface presenter {
        void clickedButton();
    }
}