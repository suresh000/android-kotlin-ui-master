package com.kotlin.ui.mvp.login;

public class MVPPresenter {

    private MVPView mMVPView;
    private MVPModel mMVPModel;

    MVPPresenter(MVPView mvpView, MVPModel mvpModel) {
        mMVPView = mvpView;
        mMVPModel = mvpModel;
    }

    public void onDestroy() {
        mMVPView = null;
        mMVPModel = null;
    }

    public void validateCredentials(String username, String password) {
        if (mMVPView != null) {
            mMVPView.showProgress();
        }

        mMVPModel.login(username, password, new MVPModel.OnLoginFinishedListener() {
            @Override
            public void onUsernameError() {
                if (mMVPView != null) {
                    mMVPView.setUsernameError();
                    mMVPView.hideProgress();
                }
            }

            @Override
            public void onPasswordError() {
                if (mMVPView != null) {
                    mMVPView.setPasswordError();
                    mMVPView.hideProgress();
                }
            }

            @Override
            public void onSuccess() {
                if (mMVPView != null) {
                    mMVPView.navigateToHome();
                }
            }
        });
    }
}
