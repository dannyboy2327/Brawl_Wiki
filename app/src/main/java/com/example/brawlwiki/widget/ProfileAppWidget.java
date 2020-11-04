package com.example.brawlwiki.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

import com.example.brawlwiki.MainActivity;
import com.example.brawlwiki.R;
import com.example.brawlwiki.models.profile.Player;
import com.example.brawlwiki.ui.home.HomeFragment;

public class ProfileAppWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                Player player, int appWidgetId) {

        Intent updateIntent = new Intent(context, ProfileAppWidgetService.class);
        updateIntent.setAction(ProfileAppWidgetService.ACTION_UPDATE_TROPHIES);
        PendingIntent updatePendingIntent = PendingIntent.getService(
                context,
                0,
                updateIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);


        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.profile_app_widget);

        views.setOnClickPendingIntent(R.id.iv_brawler_image, pendingIntent);
        views.setOnClickPendingIntent(R.id.bt_widget_update, updatePendingIntent);

        if (!(player == null)) {
            views.setTextViewText(R.id.tv_widget_name, player.getName());
            views.setTextViewText(R.id.tv_widget_trophies, player.getTrophies().toString());
            switch (player.getPlayerIcon().getId()) {
                case 28000000:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_skull);
                    break;
                //robot
                case 28000001:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_robot);
                    break;
                //slime
                case 28000002:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_slime);
                    break;
                //shelly
                case 28000003:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_shelly);
                    break;
                //colt
                case 28000004:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_colt);
                    break;
                //brock
                case 28000005:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_brock);
                    break;
                //jessie
                case 28000006:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_jessie);
                    break;
                //nita
                case 28000007:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_nita);
                    break;
                //dynamike
                case 28000008:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_dynamike);
                    break;
                //el primo
                case 28000009:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_primo);
                    break;
                //bull
                case 28000010:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_bull);
                    break;
                //rico
                case 28000011:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_rico);
                    break;
                //barley
                case 28000012:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_barley);
                    break;
                //poco
                case 28000013:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_poco);
                    break;
                //mortis
                case 28000014:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_mortis);
                    break;
                //bo
                case 28000015:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_bo);
                    break;
                //spike
                case 28000016:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_spike);
                    break;
                //crow
                case 28000017:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_crow);
                    break;
                //piper
                case 28000018:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_piper);
                    break;
                //bandit
                case 28000019:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_bandit);
                    break;
                //star
                case 28000020:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_star);
                    break;
                //crown
                case 28000021:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_crown);
                    break;
                //bottle
                case 28000022:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_bottle);
                    break;
                //red skull
                case 28000023:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_red_skull);
                    break;
                //1st trophy
                case 28000024:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_first_trophy);
                    break;
                //2nd trophy
                case 28000025:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_second_trophy);
                    break;
                //3rd trophy
                case 28000026:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_third_trophy);
                    break;
                //4th trophy
                case 28000027:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_fourth_trophy);
                    break;
                //pam
                case 28000028:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_pam);
                    break;
                //tara
                case 28000029:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_tara);
                    break;
                //5th trophy
                case 28000030:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_fifth_trophy);
                    break;
                //6th trophy
                case 28000031:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_sixth_trophy);
                    break;
                //7th trophy
                case 28000032:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_seventh_trophy);
                    break;
                //8th trophy
                case 28000033:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_eigth_trophy);
                    break;
                //darryl
                case 28000034:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_darryl);
                    break;
                //penny
                case 28000035:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_penny);
                    break;
                //frank
                case 28000036:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_frank);
                    break;
                //leon
                case 28000037:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_leon);
                    break;
                //gene
                case 28000038:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_gene);
                    break;
                //carl
                case 28000039:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_carl);
                    break;
                //rosa
                case 28000040:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_rosa);
                    break;
                //bibi
                case 28000041:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_bibi);
                    break;
                //tick
                case 28000042:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_tick);
                    break;
                //8-bit
                case 28000043:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_bit);
                    break;
                //sandy
                case 28000044:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_sandy);
                    break;
                //emz
                case 28000045:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_emz);
                    break;
                //bea
                case 28000046:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_bea);
                    break;
                //max
                case 28000047:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_max);
                    break;
                //mrp
                case 28000048:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_mrp);
                    break;
                //jacky
                case 28000049:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_jacky);
                    break;
                //sprout
                case 28000050:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_sprout);
                    break;
                //surge
                case 28000051:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_surge);
                    break;
                //nani
                case 28000052:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_nani);
                    break;
                //surge
                case 28000053:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_surge);
                    break;
                //colette
                case 28000054:
                    views.setImageViewResource(R.id.iv_widget_image, R.drawable.player_colette);
                    break;
                default:

            }
        } else {
            String no_name = "No name found";
            String no_trophy = "No trophies found";
            views.setTextViewText(R.id.tv_widget_name, no_name);
            views.setImageViewResource(R.id.iv_widget_image, R.drawable.brawl_wiki_logo);
            views.setTextViewText(R.id.tv_widget_trophies, no_trophy);

        }

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        ProfileAppWidgetService.startActionUpdateTrophies(context);
    }

    public static void updateProfileAppWidgets(Context context, AppWidgetManager appWidgetManager, Player player, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, player, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}