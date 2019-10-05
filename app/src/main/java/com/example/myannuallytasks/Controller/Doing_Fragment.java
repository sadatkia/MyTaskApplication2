package com.example.myannuallytasks.Controller;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myannuallytasks.R;
import com.example.myannuallytasks.model.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Doing_Fragment extends Fragment {
    private  ImageView mBackground;
    private FloatingActionButton mFloatingAction_Doing;

    private RecyclerView mRecyclerView;
    private TaskAdapter_Doing mTaskAdapter_Doing ;

    public Doing_Fragment() {
        // Required empty public constructor
    }
///////////////////
public static Doing_Fragment newInstance() {
    Bundle args = new Bundle();

    Doing_Fragment fragment = new Doing_Fragment();
    fragment.setArguments(args);
    return fragment;
}
////////////////////////////////////////////////////////
@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setHasOptionsMenu(true);
}

/////////////////////////////////////////////////////////////////////
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_doing_, container, false);

        mBackground = view.findViewById(R.id.id_imageView_RecycelerView);
        mFloatingAction_Doing=view.findViewById(R.id.id_floating_add_doing);
        mRecyclerView=view.findViewById(R.id.id_imageView_RecycelerView);
        ////////////////////////Floating Action Button////////
        mFloatingAction_Doing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                getActivity().getSupportFragmentManager();
                AddDialogFragment fragment=new AddDialogFragment();
                fragment.show(getFragmentManager(), " My Add ");
            }
        });

        return view;
    }

    ///////////////////////////////////////Loge Off Section /////////////////////////////
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.taskmenu, menu);

        MenuItem subtitleItem = menu.findItem(R.id.id_LogOff);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_LogOff:
                Intent intent =new Intent(getActivity(), First_Activity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
/////////////////////////////////////Recyceler View Section////////////////
    private class TaskDoingHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewTitle;
        // private TextView mTextViewDate;
        private ImageView mImageViewTask;

        private Task mTask;

        public TaskDoingHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewTitle = itemView.findViewById(R.id.id_textView_RecycelerView);
            // mTextViewDate = itemView.findViewById(R.id.txtview_list_item_date);
            mImageViewTask = itemView.findViewById(R.id.id_imageView_RecycelerView);

     /*       itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = TaskPagerActivity.newIntent(getActivity(), mTask.getId());
                    startActivity(intent);
                }
            });*/
        }

        public void bind(Task Task) {
            mTask = Task;
            mTextViewTitle.setText(Task.getmTitle());
            //mTextViewDate.setText(Task.getDate().toString());
            // mImageViewTask.setVisibility();
        }
    }

    private class TaskAdapter_Doing extends RecyclerView.Adapter<TaskDoingHolder> {

        public static final String TAG = "TaskAdapter";
        private List<Task> mTasks;

        public TaskAdapter_Doing(List<Task> Tasks) {
            mTasks = Tasks;
        }

        public void setTasks(List<Task> Tasks) {
            mTasks = Tasks;
        }

        @NonNull
        @Override
        public TaskDoingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d(TAG, "onCreateViewHolder");
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.item_layout_recycelerview, parent, false);
            return new Doing_Fragment.TaskDoingHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TaskDoingHolder holder, int position) {
            Log.d(TAG, "onBindViewHolder");
            holder.bind(mTasks.get(position));
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }

}
