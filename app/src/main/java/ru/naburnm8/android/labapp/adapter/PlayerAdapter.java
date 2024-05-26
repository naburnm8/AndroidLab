package ru.naburnm8.android.labapp.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
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
    public void Sort(String type){
        switch (type){
            case "name":
                SortNick();
                break;
            case "date":
                SortDate();
                break;
            case "win":
                SortWinPercent();
                break;
        }
    }
    private void SortNick(){
        for(int i = 0; i < userData.size(); i++){
            int index = nickFind(i);
            UserData temp = userData.get(i);
            userData.set(i, userData.get(index));
            userData.set(index, temp);

        }
    }
    private void SortDate(){
        for(int i = 0; i < userData.size(); i++){
            int index = dateFind(i);
            UserData temp = userData.get(i);
            userData.set(i, userData.get(index));
            userData.set(index, temp);
        }
    }
    private void SortWinPercent(){
        for(int i = 0; i < userData.size(); i++){
            int index = winFind(i);
            UserData temp = userData.get(i);
            userData.set(i, userData.get(index));
            userData.set(index, temp);
        }
    }
    private int nickFind(int l){
        int ipos = 0;
        int min = 9000;
        for (int i = l; i < userData.size(); i++) {
            int firstChar = userData.get(i).getNickname().toLowerCase().charAt(0);
            if (firstChar < min) {
                min = firstChar;
                ipos = i;
            }
        }
        return ipos;
    }
    private int dateFind(int l){
        int ipos = 0;
        long min = 999999999;
        for(int i = l; i < userData.size(); i++){
            long date = dateToDays(userData.get(i).getDateOfRegistration());
            if(date < min){
                min = date;
                ipos = i;
            }
        }
        return ipos;
    }
    private int winFind(int l){
        int ipos = 0;
        int min = 100;
        for (int i = l; i < userData.size(); i++){
            int percent = getIntPercent(userData.get(i).getWinPercent());
            if(percent < min){
                min = percent;
                ipos = i;
            }
        }
        return ipos;
    }
    private long dateToDays(String date){
        String[] split = date.split("-");
        long[] dateInt = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            dateInt[i] = Integer.parseInt(split[i]);
        }
        return dateInt[0] + dateInt[1]*30 + (dateInt[2] - 1970)*365;
    }
    private int getIntPercent(String percent){
        percent = percent.replaceAll("%", "");
        return Integer.parseInt(percent);
    }
}
