package  com.droid_app_dev.serialportcommunication.activity.base;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

import com.droid_app_dev.serialportcommunication.R;
import com.droid_app_dev.serialportcommunication.comn.message.IMessage;
import com.droid_app_dev.serialportcommunication.comn.message.LogManager;
import com.droid_app_dev.serialportcommunication.fragment.LogFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseActivity extends AppCompatActivity {

    protected ActionBar mActionBar;
    private LogFragment mLogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        if (hasActionBar()) {
            mActionBar = getSupportActionBar();
        }
        initFragment();
    }

    /**
     *
     *
     * @return
     */
    protected abstract int getLayoutId();

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshLogList();
    }

    /**
     *
     */
    protected void refreshLogList() {
        mLogFragment.updateAutoEndButton();
        mLogFragment.updateList();
    }

    /**
     * Fragment
     */
    protected void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        mLogFragment = (LogFragment) fragmentManager.findFragmentById(R.id.log_fragment);
    }

    /**
     *
     *
     * @param message
     */
    protected void addLog(IMessage message) {
        LogManager.instance().add(message);
        refreshLogList();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    protected boolean hasActionBar() {
        return true;
    }

    protected void setActionBar(boolean showUp, String title) {
        mActionBar.setHomeButtonEnabled(showUp);
        mActionBar.setDisplayHomeAsUpEnabled(showUp);
        mActionBar.setTitle(title);
    }

    protected void setActionBar(boolean showUp, int stringResId) {
        mActionBar.setHomeButtonEnabled(showUp);
        mActionBar.setDisplayHomeAsUpEnabled(showUp);
        mActionBar.setTitle(stringResId);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(IMessage message) {
        //
        mLogFragment.add(message);
    }

    public abstract void onItemClick(AdapterView<?> parent, View view, int position, long id);
}
