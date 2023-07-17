// Generated code from Butter Knife. Do not modify!
package com.droid_app_dev.serialportcommunication.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.droid_app_dev.serialportcommunication.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoadCmdListActivity_ViewBinding implements Unbinder {
  private LoadCmdListActivity target;

  private View view7f080044;

  @UiThread
  public LoadCmdListActivity_ViewBinding(LoadCmdListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoadCmdListActivity_ViewBinding(final LoadCmdListActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_load_list, "field 'mBtnLoadList' and method 'onViewClicked'");
    target.mBtnLoadList = Utils.castView(view, R.id.btn_load_list, "field 'mBtnLoadList'", Button.class);
    view7f080044 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mListView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'mListView'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoadCmdListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBtnLoadList = null;
    target.mListView = null;

    view7f080044.setOnClickListener(null);
    view7f080044 = null;
  }
}
