package com.example.addingplayers.Adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.addingplayers.Activities.AddPlayerActivity;
import com.example.addingplayers.Activities.MainActivity;
import com.example.addingplayers.Models.Team;
import com.example.addingplayers.R;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    MainActivity mainActivity;
    List<Team> teams;

    public TeamAdapter(MainActivity mainActivity, List<Team> teams) {
        this.mainActivity = mainActivity;
        this.teams = teams;
    }

    @NonNull
    @Override
    public TeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mainActivity)
                .inflate(R.layout.team_row,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.ViewHolder viewHolder, int i) {
        viewHolder.matches.setText(""+teams.get(i).getMatches());
        viewHolder.won.setText(""+teams.get(i).getMatches_won());
        viewHolder.loss.setText(""+teams.get(i).getMatches_lost());
        viewHolder.team_name.setText(teams.get(i).getTeam_name());
    }

    @Override
    public int getItemCount() {
        return teams!=null?teams.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView pic,del;
        TextView team_name,matches,won,loss;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            team_name = itemView.findViewById(R.id.team_view_id);
            matches = itemView.findViewById(R.id.matches_view_id);
            won = itemView.findViewById(R.id.won_view_id);
            loss = itemView.findViewById(R.id.lost_view_id);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mainActivity, AddPlayerActivity.class);
            //intent.putParcelableArrayListExtra("players_list", (ArrayList<? extends Parcelable>) teams.get(getAdapterPosition()).getPlayersList());
            intent.putExtra("team_id",teams.get(getAdapterPosition()).getTeam_id());
            intent.putExtra("team_name",teams.get(getAdapterPosition()).getTeam_name());
            mainActivity.startActivity(intent);

        }
    }
}
