package ru.naburnm8.android.labapp.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import ru.naburnm8.android.labapp.R;

public class PlayerListViewHolder extends RecyclerView.ViewHolder{
    public TextView nickname;
    public TextView dateOfRegistration;
    public TextView winPercent;
    public TextView favouriteUnitType;
    public View view;
    public PlayerListViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        nickname = itemView.findViewById(R.id.nicknameList);
        dateOfRegistration = itemView.findViewById(R.id.dateRegistrationList);
        winPercent = itemView.findViewById(R.id.winPercentageList);
        favouriteUnitType = itemView.findViewById(R.id.favouriteUnitTypeList);
        view = itemView;
    }
}
