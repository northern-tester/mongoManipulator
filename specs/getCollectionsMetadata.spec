Grab a document or set of documents and find something
======================================================

This is an executable specification file. This file follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, run
	gauge specs/getCollectionsMetadata

* To connect to "workstation" I need a host of "33.33.34.10" and a port of "27017".

Get the number of documents in a collection
-------------------------------------------

tags: collections

* The number of documents within the "images" collection within the "content-store" db is "50".

Get the number of documents within multiple collections
-------------------------------------------------------

* Each collection within "event-store" will have a specified number of documents.
         |Collection    |Documents  |
         |--------------|-----------|
         |couponmarkets |13         |
         |markets       |55251      |
         |priceboosts   |0          |
         |raw           |17546      |
         |rawcoupon     |2          |

Get the metadata of a collection to check its size and status
-------------------------------------------------------------

* The "couponmarkets" collection within the "content-store" db will have the following attributes.
             |Attribute |Value  |
             |----------|-------|
             |numExtents|1      |
             |userFlags |1      |
             |capped    |false  |
             |nindexes  |4      |
