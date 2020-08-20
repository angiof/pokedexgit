package com.example.myapplicationrxretrofit.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationrxretrofit.R;
import com.example.myapplicationrxretrofit.models.GitHubreppo;

import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {

    private List<GitHubreppo> gitHubreppos;

    public RepositoryAdapter(List<GitHubreppo> gitHubreppos) {
        this.gitHubreppos = gitHubreppos;
    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_repo, parent,false);

        return new RepositoryViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolder holder, int position) {

        GitHubreppo repo=gitHubreppos.get(position);
        holder.textViewRepositorio.setText(repo.getName());
        holder.textViewLenguage.setText(repo.getLanguage());
        holder.textViewStars.setText(repo.getStartgazers_count()+"");



    }

    @Override
    public int getItemCount() {
        return gitHubreppos.size();
    }

    public void setdata(List<GitHubreppo> gitHubreppos){

        this.gitHubreppos=gitHubreppos;
        notifyDataSetChanged();
    }

    public class RepositoryViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewRepositorio, textViewLenguage, textViewStars;

        private RepositoryViewHolder(View itemview) {
            super(itemview);

            textViewRepositorio = itemview.findViewById(R.id.tvRepositorio);
            textViewLenguage = itemview.findViewById(R.id.tvLenguaje);
            textViewStars = itemview.findViewById(R.id.tvStars);


        }
    }

}
