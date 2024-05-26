package ru.naburnm8.android.labapp.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ru.naburnm8.android.labapp.R;

public class BattleViewHolder extends RecyclerView.ViewHolder {
    public TextView player1;
    public TextView player2;
    public TextView date;
    public View view;
    public BattleViewHolder(View itemView) {
        super(itemView);
        player1 = itemView.findViewById(R.id.player1);
        player2 = itemView.findViewById(R.id.player2);
        date = itemView.findViewById(R.id.date);
        view = itemView;
    }

}
