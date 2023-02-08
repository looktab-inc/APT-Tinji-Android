/*
 * idl
 * Metaplex
 * 
 * Created by Funkatronics on 9/16/2022
 */

package com.metaplex.lib.experimental.jen.candymachine

val candyCoreJson = """
    {
      "version": "0.0.2",
      "name": "candy_machine_core",
      "instructions": [
        {
          "name": "addConfigLines",
          "docs": [
            "Add the configuration (name + uri) of each NFT to the account data."
          ],
          "accounts": [
            {
              "name": "candyMachine",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "authority",
              "isMut": false,
              "isSigner": true
            }
          ],
          "args": [
            {
              "name": "index",
              "type": "u32"
            },
            {
              "name": "configLines",
              "type": {
                "vec": {
                  "defined": "ConfigLine"
                }
              }
            }
          ]
        },
        {
          "name": "initialize",
          "docs": [
            "Initialize the candy machine account with the specified data."
          ],
          "accounts": [
            {
              "name": "candyMachine",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "authorityPda",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "authority",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "payer",
              "isMut": false,
              "isSigner": true
            },
            {
              "name": "collectionMetadata",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "collectionMint",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "collectionMasterEdition",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "collectionUpdateAuthority",
              "isMut": true,
              "isSigner": true
            },
            {
              "name": "collectionAuthorityRecord",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "tokenMetadataProgram",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "systemProgram",
              "isMut": false,
              "isSigner": false
            }
          ],
          "args": [
            {
              "name": "data",
              "type": {
                "defined": "CandyMachineData"
              }
            }
          ]
        },
        {
          "name": "mint",
          "docs": [
            "Mint an NFT. Only the candy machine mint authority is allowed to mint."
          ],
          "accounts": [
            {
              "name": "candyMachine",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "authorityPda",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "mintAuthority",
              "isMut": false,
              "isSigner": true
            },
            {
              "name": "payer",
              "isMut": true,
              "isSigner": true
            },
            {
              "name": "nftMint",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "nftMintAuthority",
              "isMut": false,
              "isSigner": true
            },
            {
              "name": "nftMetadata",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "nftMasterEdition",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "collectionAuthorityRecord",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "collectionMint",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "collectionMetadata",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "collectionMasterEdition",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "collectionUpdateAuthority",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "tokenMetadataProgram",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "tokenProgram",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "systemProgram",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "recentSlothashes",
              "isMut": false,
              "isSigner": false
            }
          ],
          "args": []
        },
        {
          "name": "setAuthority",
          "docs": [
            "Set a new authority of the candy machine."
          ],
          "accounts": [
            {
              "name": "candyMachine",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "authority",
              "isMut": false,
              "isSigner": true
            }
          ],
          "args": [
            {
              "name": "newAuthority",
              "type": "publicKey"
            }
          ]
        },
        {
          "name": "setCollection",
          "docs": [
            "Set the collection mint for the candy machine."
          ],
          "accounts": [
            {
              "name": "candyMachine",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "authority",
              "isMut": false,
              "isSigner": true
            },
            {
              "name": "authorityPda",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "payer",
              "isMut": false,
              "isSigner": true
            },
            {
              "name": "collectionMint",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "collectionMetadata",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "collectionAuthorityRecord",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "newCollectionUpdateAuthority",
              "isMut": true,
              "isSigner": true
            },
            {
              "name": "newCollectionMetadata",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "newCollectionMint",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "newCollectionMasterEdition",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "newCollectionAuthorityRecord",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "tokenMetadataProgram",
              "isMut": false,
              "isSigner": false
            },
            {
              "name": "systemProgram",
              "isMut": false,
              "isSigner": false
            }
          ],
          "args": []
        },
        {
          "name": "setMintAuthority",
          "docs": [
            "Set a new mint authority of the candy machine."
          ],
          "accounts": [
            {
              "name": "candyMachine",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "authority",
              "isMut": false,
              "isSigner": true
            },
            {
              "name": "mintAuthority",
              "isMut": false,
              "isSigner": true
            }
          ],
          "args": []
        },
        {
          "name": "update",
          "docs": [
            "Update the candy machine configuration."
          ],
          "accounts": [
            {
              "name": "candyMachine",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "authority",
              "isMut": false,
              "isSigner": true
            }
          ],
          "args": [
            {
              "name": "data",
              "type": {
                "defined": "CandyMachineData"
              }
            }
          ]
        },
        {
          "name": "withdraw",
          "docs": [
            "Withdraw the rent lamports and send them to the authority address."
          ],
          "accounts": [
            {
              "name": "candyMachine",
              "isMut": true,
              "isSigner": false
            },
            {
              "name": "authority",
              "isMut": true,
              "isSigner": true
            }
          ],
          "args": []
        }
      ],
      "accounts": [
        {
          "name": "CandyMachine",
          "docs": [
            "Candy machine state and config data."
          ],
          "type": {
            "kind": "struct",
            "fields": [
              {
                "name": "features",
                "docs": [
                  "Features versioning flags."
                ],
                "type": "u64"
              },
              {
                "name": "authority",
                "docs": [
                  "Authority address."
                ],
                "type": "publicKey"
              },
              {
                "name": "mintAuthority",
                "docs": [
                  "Authority address allowed to mint from the candy machine."
                ],
                "type": "publicKey"
              },
              {
                "name": "collectionMint",
                "docs": [
                  "The collection mint for the candy machine."
                ],
                "type": "publicKey"
              },
              {
                "name": "itemsRedeemed",
                "docs": [
                  "Number of assets redeemed."
                ],
                "type": "u64"
              },
              {
                "name": "data",
                "docs": [
                  "Candy machine configuration data."
                ],
                "type": {
                  "defined": "CandyMachineData"
                }
              }
            ]
          }
        }
      ],
      "types": [
        {
          "name": "CandyMachineData",
          "docs": [
            "Candy machine configuration data."
          ],
          "type": {
            "kind": "struct",
            "fields": [
              {
                "name": "itemsAvailable",
                "docs": [
                  "Number of assets available"
                ],
                "type": "u64"
              },
              {
                "name": "symbol",
                "docs": [
                  "Symbol for the asset"
                ],
                "type": "string"
              },
              {
                "name": "sellerFeeBasisPoints",
                "docs": [
                  "Secondary sales royalty basis points (0-10000)"
                ],
                "type": "u16"
              },
              {
                "name": "maxSupply",
                "docs": [
                  "Max supply of each individual asset (default 0)"
                ],
                "type": "u64"
              },
              {
                "name": "isMutable",
                "docs": [
                  "Indicates if the asset is mutable or not (default yes)"
                ],
                "type": "bool"
              },
              {
                "name": "creators",
                "docs": [
                  "List of creators"
                ],
                "type": {
                  "vec": {
                    "defined": "Creator"
                  }
                }
              },
              {
                "name": "configLineSettings",
                "docs": [
                  "Config line settings"
                ],
                "type": {
                  "option": {
                    "defined": "ConfigLineSettings"
                  }
                }
              },
              {
                "name": "hiddenSettings",
                "docs": [
                  "Hidden setttings"
                ],
                "type": {
                  "option": {
                    "defined": "HiddenSettings"
                  }
                }
              }
            ]
          }
        },
        {
          "name": "Creator",
          "type": {
            "kind": "struct",
            "fields": [
              {
                "name": "address",
                "docs": [
                  "Pubkey address"
                ],
                "type": "publicKey"
              },
              {
                "name": "verified",
                "docs": [
                  "Whether the creator is verified or not"
                ],
                "type": "bool"
              },
              {
                "name": "percentageShare",
                "type": "u8"
              }
            ]
          }
        },
        {
          "name": "HiddenSettings",
          "docs": [
            "Hidden settings for large mints used with off-chain data."
          ],
          "type": {
            "kind": "struct",
            "fields": [
              {
                "name": "name",
                "docs": [
                  "Asset prefix name"
                ],
                "type": "string"
              },
              {
                "name": "uri",
                "docs": [
                  "Shared URI"
                ],
                "type": "string"
              },
              {
                "name": "hash",
                "docs": [
                  "Hash of the hidden settings file"
                ],
                "type": {
                  "array": [
                    "u8",
                    32
                  ]
                }
              }
            ]
          }
        },
        {
          "name": "ConfigLineSettings",
          "docs": [
            "Config line settings to allocate space for individual name + URI."
          ],
          "type": {
            "kind": "struct",
            "fields": [
              {
                "name": "prefixName",
                "docs": [
                  "Common name prefix"
                ],
                "type": "string"
              },
              {
                "name": "nameLength",
                "docs": [
                  "Length of the remaining part of the name"
                ],
                "type": "u32"
              },
              {
                "name": "prefixUri",
                "docs": [
                  "Common URI prefix"
                ],
                "type": "string"
              },
              {
                "name": "uriLength",
                "docs": [
                  "Length of the remaining part of the URI"
                ],
                "type": "u32"
              },
              {
                "name": "isSequential",
                "docs": [
                  "Indicates whether to use a senquential index generator or not"
                ],
                "type": "bool"
              }
            ]
          }
        },
        {
          "name": "ConfigLine",
          "docs": [
            "Config line struct for storing asset (NFT) data pre-mint."
          ],
          "type": {
            "kind": "struct",
            "fields": [
              {
                "name": "name",
                "docs": [
                  "Name of the asset."
                ],
                "type": "string"
              },
              {
                "name": "uri",
                "docs": [
                  "URI to JSON metadata."
                ],
                "type": "string"
              }
            ]
          }
        }
      ],
      "errors": [
        {
          "code": 6000,
          "name": "IncorrectOwner",
          "msg": "Account does not have correct owner"
        },
        {
          "code": 6001,
          "name": "Uninitialized",
          "msg": "Account is not initialized"
        },
        {
          "code": 6002,
          "name": "MintMismatch",
          "msg": "Mint Mismatch"
        },
        {
          "code": 6003,
          "name": "IndexGreaterThanLength",
          "msg": "Index greater than length"
        },
        {
          "code": 6004,
          "name": "NumericalOverflowError",
          "msg": "Numerical overflow error"
        },
        {
          "code": 6005,
          "name": "TooManyCreators",
          "msg": "Can only provide up to 4 creators to candy machine (because candy machine is one)"
        },
        {
          "code": 6006,
          "name": "CandyMachineEmpty",
          "msg": "Candy machine is empty"
        },
        {
          "code": 6007,
          "name": "HiddenSettingsDoNotHaveConfigLines",
          "msg": "Candy machines using hidden uris do not have config lines, they have a single hash representing hashed order"
        },
        {
          "code": 6008,
          "name": "CannotChangeNumberOfLines",
          "msg": "Cannot change number of lines unless is a hidden config"
        },
        {
          "code": 6009,
          "name": "CannotSwitchToHiddenSettings",
          "msg": "Cannot switch to hidden settings after items available is greater than 0"
        },
        {
          "code": 6010,
          "name": "IncorrectCollectionAuthority",
          "msg": "Incorrect collection NFT authority"
        },
        {
          "code": 6011,
          "name": "MetadataAccountMustBeEmpty",
          "msg": "The metadata account has data in it, and this must be empty to mint a new NFT"
        },
        {
          "code": 6012,
          "name": "NoChangingCollectionDuringMint",
          "msg": "Can't change collection settings after items have begun to be minted"
        },
        {
          "code": 6013,
          "name": "ExceededLengthError",
          "msg": "Value longer than expected maximum value"
        },
        {
          "code": 6014,
          "name": "MissingConfigLinesSettings",
          "msg": "Missing config lines settings"
        },
        {
          "code": 6015,
          "name": "CannotIncreaseLength",
          "msg": "Cannot increase the length in config lines settings"
        },
        {
          "code": 6016,
          "name": "CannotSwitchFromHiddenSettings",
          "msg": "Cannot switch from hidden settings"
        },
        {
          "code": 6017,
          "name": "CannotChangeSequentialIndexGeneration",
          "msg": "Cannot change sequential index generation after items have begun to be minted"
        },
        {
          "code": 6018,
          "name": "CollectionKeyMismatch",
          "msg": "Collection public key mismatch"
        },
        {
          "code": 6019,
          "name": "CouldNotRetrieveConfigLineData",
          "msg": "Could not retrive config line data"
        },
        {
          "code": 6020,
          "name": "NotFullyLoaded",
          "msg": "Not all config lines were added to the candy machine"
        }
      ],
      "metadata": {
        "address": "CndyV3LdqHUfDLmE5naZjVN8rBZz4tqhdefbAnjHG3JR",
        "origin": "anchor",
        "binaryVersion": "0.25.0",
        "libVersion": "0.25.0"
      }
    }
""".trimIndent()