// Generated by view binder compiler. Do not edit!
package santiago.avila.carritocompra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import santiago.avila.carritocompra.R;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnVerCarro;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final RecyclerView rvListaProductos;

  @NonNull
  public final TextView tvCantProductos;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnVerCarro,
      @NonNull LinearLayout linearLayout, @NonNull RecyclerView rvListaProductos,
      @NonNull TextView tvCantProductos) {
    this.rootView = rootView;
    this.btnVerCarro = btnVerCarro;
    this.linearLayout = linearLayout;
    this.rvListaProductos = rvListaProductos;
    this.tvCantProductos = tvCantProductos;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnVerCarro;
      Button btnVerCarro = ViewBindings.findChildViewById(rootView, id);
      if (btnVerCarro == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.rvListaProductos;
      RecyclerView rvListaProductos = ViewBindings.findChildViewById(rootView, id);
      if (rvListaProductos == null) {
        break missingId;
      }

      id = R.id.tvCantProductos;
      TextView tvCantProductos = ViewBindings.findChildViewById(rootView, id);
      if (tvCantProductos == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, btnVerCarro, linearLayout,
          rvListaProductos, tvCantProductos);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
