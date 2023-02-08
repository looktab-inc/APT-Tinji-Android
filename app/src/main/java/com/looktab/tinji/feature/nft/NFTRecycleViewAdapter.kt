package com.looktab.tinji.feature.nft


/*class NFTRecycleViewAdapter(
    private val context: Context,
    private val metaplex: Metaplex,
    private val dataSet: Array<NFT>,
    private val ownerPublicKey: PublicKey
) :
    RecyclerView.Adapter<NFTRecycleViewAdapter.NftViewHolder>() {

    inner class NftViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: ItemNftRowBinding? =
            androidx.databinding.DataBindingUtil.bind(itemView)

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind() {
            binding?.let {
                binding
                binding.name = dataSet[layoutPosition].metadataAccount.data.name
                binding.tag = position.toString()

                dataSet[position].metadata(metaplex) { result ->
                    result.onSuccess {
                        binding.image = it.image
                    }
                }



                itemView.setOnClickListener {

                    Log.e("123", dataSet[position].name)
                    Log.e("123", dataSet[position].toString())
                    val context = binding.nftImageView.context
                    val intent = Intent(context, NftDetailsActivity::class.java)
                    val extras = Bundle()
                    extras.putString(
                        NftDetailsActivity.NFT_NAME,
                        dataSet[position].metadataAccount.data.name
                    )

                    extras.putString(NftDetailsActivity.NFT_OWNER, ownerPublicKey.toBase58())
                    extras.putString(
                        NftDetailsActivity.MINT_ACCOUNT,
                        dataSet[position].metadataAccount.mint.toBase58()
                    )
                    intent.putExtras(extras)
                    context.startActivity(intent)
                }

//                dataSet[position].metadata(metaplex) { result ->
//                    result.onSuccess {
//                        if (binding.nftImageView.tag == position) {
//                            // Don't Use this change of thread hack. This is a over simplify example.
//                            Handler(Looper.getMainLooper()).post(Runnable {
//                                val factory =
//                                    DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true)
//                                        .build()
//                                Glide
//                                    .with(context)
//                                    .load(it.image)
//                                    .transition(DrawableTransitionOptions.withCrossFade(factory))
//                                    .centerCrop()
//                                    .apply(
//                                        RequestOptions().transform(RoundedCorners(24))
//                                            .skipMemoryCache
//                                                (true)
//                                    )
//                                    .into(binding.nftImageView)
//                            })
//                        }
//                    }
//                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): NftViewHolder {
        return NftViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_nft_row, viewGroup, false)
        )
    }

    override fun onBindViewHolder(holder: NftViewHolder, position: Int) {
        holder.bind()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}
*/