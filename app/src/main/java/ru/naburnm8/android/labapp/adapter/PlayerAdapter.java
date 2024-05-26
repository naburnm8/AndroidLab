package ru.naburnm8.android.labapp.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import ru.naburnm8.android.labapp.R;
import ru.naburnm8.android.labapp.data.UserData;
import ru.naburnm8.android.labapp.viewholder.PlayerListViewHolder;

import java.util.ArrayList;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerListViewHolder> {
    private final ArrayList<UserData> userData;
    private final LayoutInflater inflater;
    Context context;

    public PlayerAdapter(Context context, ArrayList<UserData> userData) {
        this.userData = userData;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @NotNull
    @Override
    public PlayerListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_view_players, parent, false);
        return new PlayerListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PlayerListViewHolder holder, int position) {
        String nickname = userData.get(position).getNickname();
        String dateOfRegistration = userData.get(position).getDateOfRegistration();
        String winPercentage = userData.get(position).getWinPercent();
        String favouriteUnitType = userData.get(position).getFavouriteUnitType();
        holder.nickname.setText(nickname);
        holder.dateOfRegistration.setText(dateOfRegistration);
        holder.winPercent.setText(winPercentage);
        holder.favouriteUnitType.setText(favouriteUnitType);
    }
    @Override
    public int getItemCount() {
        return userData.size();
    }
}
