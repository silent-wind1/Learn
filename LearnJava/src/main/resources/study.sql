SELECT oc.FStoreId,
       oc.FNumber AS TankNo,
       oc.FSkuId,
       oc.FSkuNumber,
       s.FDataTime,
       s.FOilHeight,
       s.FWaterHeight,
       s.FOilTemp,
       s.FLiquidValue
FROM t_store_oilcan oc
         LEFT JOIN (SELECT x.FStoreId, x.FNumber, x.FDataTime, x.FOilHeight, x.FWaterHeight, x.FOilTemp, x.FLiquidValue
                    FROM t_store_oil_canstatus x
                             INNER JOIN (SELECT FStoreId, FNumber, MAX(FDataTime) AS MaxTime
                                         FROM t_store_oil_canstatus
                                         GROUP BY FStoreId, FNumber) m
                                        ON m.FStoreId = x.FStoreId AND m.FNumber = x.FNumber AND
                                           m.MaxTime = x.FDataTime) s
                   ON s.FStoreId = oc.FStoreId AND s.FNumber = oc.FNumber
WHERE oc.FStoreId = 1234;



select *
from t_store s
         left join t_store_oilcan so on s.FStoreId = so.FStoreId
left join t_store_oil_canstatus soc on soc.FStoreId = so.FStoreId and soc.FNumber = so.FNumber
where soc.FCreateTime > '2025-10-26'
group by s.Fid, soc.SkyName;