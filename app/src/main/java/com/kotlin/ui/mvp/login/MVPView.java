package com.kotlin.ui.mvp.login;

public interface MVPView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

}
