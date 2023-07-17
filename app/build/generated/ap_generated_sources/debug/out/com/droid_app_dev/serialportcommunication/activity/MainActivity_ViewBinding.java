// Generated code from Butter Knife. Do not modify!
package com.droid_app_dev.serialportcommunication.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.droid_app_dev.serialportcommunication.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view7f080045;

  private View view7f080046;

  private View view7f080044;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.mSpinnerDevices = Utils.findRequiredViewAsType(source, R.id.spinner_devices, "field 'mSpinnerDevices'", Spinner.class);
    target.mSpinnerBaudrate = Utils.findRequiredViewAsType(source, R.id.spinner_baudrate, "field 'mSpinnerBaudrate'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.btn_open_device, "field 'mBtnOpenDevice' and method 'onViewClicked'");
    target.mBtnOpenDevice = Utils.castView(view, R.id.btn_open_device, "field 'mBtnOpenDevice'", Button.class);
    view7f080045 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_data, "field 'mBtnSendData' and method 'onViewClicked'");
    target.mBtnSendData = Utils.castView(view, R.id.btn_send_data, "field 'mBtnSendData'", Button.class);
    view7f080046 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_load_list, "field 'mBtnLoadList' and method 'onViewClicked'");
    target.mBtnLoadList = Utils.castView(view, R.id.btn_load_list, "field 'mBtnLoadList'", Button.class);
    view7f080044 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mEtData = Utils.findRequiredViewAsType(source, R.id.et_data, "field 'mEtData'", EditText.class);
    target.getmListView = Utils.findRequiredViewAsType(source, R.id.list_view_, "field 'getmListView'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSpinnerDevices = null;
    target.mSpinnerBaudrate = null;
    target.mBtnOpenDevice = null;
    target.mBtnSendData = null;
    target.mBtnLoadList = null;
    target.mEtData = null;
    target.getmListView = null;

    view7f080045.setOnClickListener(null);
    view7f080045 = null;
    view7f080046.setOnClickListener(null);
    view7f080046 = null;
    view7f080044.setOnClickListener(null);
    view7f080044 = null;
  }
}
