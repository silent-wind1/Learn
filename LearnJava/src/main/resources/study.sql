SELECT oc.FStoreId,
       oc.FNumber       AS TankNo,
       oc.FSkuId,
       oc.FSkuNumber,
       s.FDataTime,
       s.FOilHeight,
       s.FWaterHeight,
       s.FOilTemp,
       s.FLiquidValue
FROM t_store_oilcan oc
         LEFT JOIN (
    SELECT x.FStoreId, x.FNumber, x.FDataTime, x.FOilHeight, x.FWaterHeight, x.FOilTemp, x.FLiquidValue
    FROM t_store_oil_canstatus x
             INNER JOIN (
        SELECT FStoreId, FNumber, MAX(FDataTime) AS MaxTime
        FROM t_store_oil_canstatus
        GROUP BY FStoreId, FNumber
    ) m ON m.FStoreId = x.FStoreId AND m.FNumber = x.FNumber AND m.MaxTime = x.FDataTime
) s ON s.FStoreId = oc.FStoreId AND s.FNumber = oc.FNumber
WHERE oc.FStoreId = 1234;