package com.kotlin.ui.mvp.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.kotlin.ui.R;
import com.kotlin.ui.databinding.ActivityMvpBinding;
import com.kotlin.ui.mvp.main.MVPMainActivity;

public class MVPActivity extends AppCompatActivity implements MVPView {

    private ActivityMvpBinding mBinding;
    private MVPPresenter mMvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvp);
        mMvpPresenter = new MVPPresenter(this, new MVPModel());
        mBinding.button.setOnClickListener(v -> validateCredentials());
    }

    @Override
    protected void onDestroy() {
        mMvpPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        mBinding.progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mBinding.progress.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        mBinding.username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        mBinding.password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MVPMainActivity.class));
        finish();
    }

    private void validateCredentials() {
        mMvpPresenter.validateCredentials(mBinding.username.getText().toString(), mBinding.password.getText().toString());
    }
}
