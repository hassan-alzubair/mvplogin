package com.hassan.mvplogin.Home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.hassan.mvplogin.Home.di.DaggerHomeComponent;
import com.hassan.mvplogin.Home.di.HomeModule;
import com.hassan.mvplogin.Home.pojo.Note;
import com.hassan.mvplogin.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeActivity extends AppCompatActivity implements HomeView, NotesRecyclerAdapter.OnNoteItemClickListener {

    @BindView(R.id.notes_recycler)
    RecyclerView recyclerView;

    private List<Note> notes = new ArrayList<>();

    private NotesRecyclerAdapter adapter;

    private Unbinder unbinder;

    @Inject
    HomePresenter presenter;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        unbinder = ButterKnife.bind(this);
        DaggerHomeComponent.builder()
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);
        adapter = new NotesRecyclerAdapter(this, notes);
        adapter.setOnNoteItemClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getNotes();
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showList(List<Note> newNotes) {
        notes.clear();
        notes.addAll(newNotes);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("fetching notes ...");
            progressDialog.setCancelable(false);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        if (!progressDialog.isShowing())
            progressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void toastNote(String note) {
        Toast.makeText(this, note, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNoteClicked(Note note) {
        presenter.onNoteClicked(note);
    }
}