package ru.naburnm8.android.labapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.naburnm8.android.labapp.BattleActivity;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import ru.naburnm8.android.labapp.R;
import ru.naburnm8.android.labapp.data.BattleData;
import ru.naburnm8.android.labapp.viewholder.BattleViewHolder;

import java.util.ArrayList;

public class BattleAdapter extends RecyclerView.Adapter<BattleViewHolder>{
    private final ArrayList<BattleData> battleData;
    private final LayoutInflater inflater;
    Context context;

    public BattleAdapter(Context context, ArrayList<BattleData> battleData) {
        this.inflater = LayoutInflater.from(context);
        this.battleData = battleData;
        this.context = context;
    }
    @NonNull
    @NotNull
    @Override
    public BattleViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_view, parent, false);
        return new BattleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BattleViewHolder holder, int position) {
        String player1 = battleData.get(position).getPlayer1();
        String player2 = battleData.get(position).getPlayer2();
        String date = battleData.get(position).getDate();
        holder.player1.setText(player1);
        holder.player2.setText(player2);
        holder.date.setText(date);
        int index = holder.getAdapterPosition();
        holder.view.setOnClickListener(view -> handleClick(index));
    }
    @Override
    public int getItemCount() {
        return battleData.size();
    }
    private void handleClick(int position) {
        //Toast.makeText(context, battleData.get(position).getPlayer1(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, BattleActivity.class);
        intent.putExtra("battleData", battleData.get(position));
        context.startActivity(intent);
    }

}
