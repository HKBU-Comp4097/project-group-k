package hk.edu.hkbu.comp.hkbumapnavigated;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.util.Linkify;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private HKBULocation[] locations;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView location;
        public TextView abbreviation;
        public ImageView image;

        public RecyclerViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.card_view);
            location = (TextView) v.findViewById(R.id.location);
            abbreviation = (TextView) v.findViewById(R.id.abbreviation);
            image = (ImageView) v.findViewById(R.id.image);
        }
    }

    public Context context;

    public RecyclerViewAdapter(HKBULocation[] locations, Context context) {
        this.locations = locations;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.location.setText(locations[position].getName());
        holder.abbreviation.setText(locations[position].getAbbreviation());
        holder.image.setImageResource(getResId(locations[position].getImage()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // location info switch here
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View infoView = layoutInflater.inflate(R.layout.location_info_card, null);
                final PopupWindow popupWindow = new PopupWindow(infoView, RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT);

                // Default info
                ((TextView) popupWindow.getContentView().findViewById(R.id.info_location)).setText(locations[position].getName());
                ((TextView) popupWindow.getContentView().findViewById(R.id.info_abbreviation)).setText(locations[position].getAbbreviation());
                ((ImageView) popupWindow.getContentView().findViewById(R.id.info_image)).setImageResource(getResId(locations[position].getImage()));

                // Dynamic Contact info
                ArrayList<HKBUDepartment> contactInfo = locations[position].getDepartments();
                float scale = context.getResources().getDisplayMetrics().density;
                int leftPadding = (int) (12 * scale + 0.5f);
                int otherPadding = 0;
                int extraBottomPadding = (int) (8 * scale + 0.5f);
                String phoneRegex = "\\([0-9]{3}\\) [0-9]{4} [0-9]{4}";
                Pattern phonePattern = Pattern.compile(phoneRegex);

                if (contactInfo == null || contactInfo.size() == 0) {
                    TextView view = new TextView(context);
                    view.setText(context.getResources().getString(R.string.no_info));
                    view.setPadding(leftPadding, otherPadding, otherPadding, otherPadding);
                    LinearLayout linearLayout = (LinearLayout) popupWindow.getContentView().findViewById(R.id.info_card);
                    linearLayout.addView(view);
                } else {
                    TextView name;
                    TextView website;
                    TextView email;
                    TextView phone;

                    for (HKBUDepartment contact: contactInfo) {
                        LinearLayout linearLayout = (LinearLayout) popupWindow.getContentView().findViewById(R.id.info_card);

                        name = new TextView(context);
                        website = new TextView(context);
                        email = new TextView(context);
                        phone = new TextView(context);

                        name.setPadding(leftPadding, otherPadding, otherPadding, otherPadding);
                        website.setPadding(leftPadding, otherPadding, otherPadding, otherPadding);
                        email.setPadding(leftPadding, otherPadding, otherPadding, otherPadding);
                        phone.setPadding(leftPadding, otherPadding, otherPadding, extraBottomPadding);

                        website.setAutoLinkMask(Linkify.WEB_URLS);
                        website.setLinksClickable(true);
                        email.setAutoLinkMask(Linkify.EMAIL_ADDRESSES);
                        email.setLinksClickable(true);

                        name.setText(Html.fromHtml(context.getResources().getString(R.string.Name) + contact.getName()));
                        website.setText(Html.fromHtml(context.getResources().getString(R.string.Website) + contact.getWebsite()));
                        email.setText(Html.fromHtml(context.getResources().getString(R.string.Email) + contact.getEmail()));
                        phone.setText(Html.fromHtml(context.getResources().getString(R.string.Tel) + contact.getTelephone()));

                        Linkify.addLinks(phone, phonePattern, context.getResources().getString(R.string.tel));
                        phone.setLinksClickable(true);

                        linearLayout.addView(name);
                        linearLayout.addView(website);
                        linearLayout.addView(email);
                        linearLayout.addView(phone);
                    }
                }

                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                popupWindow.setTouchable(true);
                popupWindow.setTouchInterceptor(new View.OnTouchListener() {
                    private long pressStartTime;
                    private float pressedX;
                    private float pressedY;
                    private static final int max_distance = 15;
                    private static final int max_duration = 1000;

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() != MotionEvent.ACTION_SCROLL) {
                            switch (event.getAction()) {
                                case MotionEvent.ACTION_DOWN: {
                                    pressStartTime = System.currentTimeMillis();
                                    pressedX = event.getX();
                                    pressedY = event.getY();
                                }
                                case MotionEvent.ACTION_UP: {
                                    if (System.currentTimeMillis() - pressStartTime < max_duration &&
                                            calcDistanceDP(pressedX, pressedY, event.getX(), event.getY()) < max_distance) {
                                        popupWindow.dismiss();
                                    }
                                }
                            }
                        }
                        return true;
                    }
                });

                popupWindow.showAtLocation(infoView, Gravity.NO_GRAVITY, 0, 0);
            }
        });
    }

    public float calcDistanceDP(float x1, float y1, float x2, float y2) {
        float dx = x1 - x2;
        float dy = y1 - y2;
        float distanceInPx = (float) Math.sqrt(dx * dx + dy * dy);
        return distanceInPx / context.getResources().getDisplayMetrics().density;
    }

    public int getResId(String resName) {
        Class res = R.drawable.class;
        try {
            Field field = res.getField(resName);
            return field.getInt(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int getItemCount() {
        return locations.length;
    }
}
